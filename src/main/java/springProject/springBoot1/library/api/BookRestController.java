package springProject.springBoot1.library.api;

import springProject.springBoot1.library.dataBase.utils.LibraryDatabaseManager;
import springProject.springBoot1.library.model.Author;
import springProject.springBoot1.library.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookRestController {

    private LibraryDatabaseManager libraryDatabaseManager;

    @GetMapping("/findAllBooksInLibrary")
    public ResponseEntity<Iterable<Book>> findAllBooksInLibrary() {
        return ResponseEntity.ok(libraryDatabaseManager.getAllBooksFromDatabase());
    }

    //http://localhost:8080/getBookById/{}
    //sprawdzic co sie stanie bez @PathVariable
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(libraryDatabaseManager.getBookById(id));
    }

    @PostMapping(path = "/addNewBook")
    public ResponseEntity addNewBook(@RequestBody Book book) {
        //weryfikacja czy uzytkownik w @RequestBody podal id autora
        Optional<Long> authorId = Optional.ofNullable(book.getAuthor().getId());

        //weryfikacja czy autor o podanym id przez uzytkownika w request body znajduje sie w naszej db
        if (authorId.isPresent()) {
            Optional<Author> optionalAuthor = isAuthorExistInDatabase(authorId.get());
            if (authorId.isPresent()) {
                //jesli istnieje to pobierz autora jesli nie else
                Author author = optionalAuthor.get();
                //dwukierunkowa relacja
                //dodajemy ksiazke do listy ksiazek pobranego z bazy danych autora
                author.addBook(book);
                // i nastepnie dla podanej ksiazki ustawiamy autora
                book.setAuthor(author);
            } else {
                //tworzymy nowego autora na podstawie danych
                Author newAuthor = createNewAuthor(book.getAuthor().getName(), book.getAuthor().getSurname());
                //w ksiazce ustawiamy nowego autora
                book.setAuthor(newAuthor);
            }
        }
        //w momencie zapisu ksiazki zapisujemy tez jej autora bo w book @ManyToOne(cascade = CascadeType.PERSIST)
        libraryDatabaseManager.addBookToDatabase(book);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/getBookById")
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    private Optional<Author> isAuthorExistInDatabase(Long authorId) {
        return Optional.ofNullable(libraryDatabaseManager.getAuthorById(authorId));
    }

    private Author createNewAuthor(String name, String surname) {
        return new Author(name, surname);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity updateBookById(@RequestBody Book book, @PathVariable Long id) {
        //ta linia pozwala pobrac ksiazke na podstawie identyfikatora
        Optional<Book> bookOptional = Optional.ofNullable(libraryDatabaseManager.getBookById(id));
        if (bookOptional.isPresent()) {
            Book updateBook = bookOptional.get();
            updateBook.setAuthor(book.getAuthor());
            updateBook.setTitle(book.getTitle());
            libraryDatabaseManager.addBookToDatabase(updateBook);
        } else {
            libraryDatabaseManager.addBookToDatabase(book);
        }

        return ResponseEntity.ok("The book has been successfully saved");
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBodyById(@PathVariable Long id) {
        libraryDatabaseManager.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
