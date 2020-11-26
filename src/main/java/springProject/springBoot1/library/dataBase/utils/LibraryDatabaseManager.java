package springProject.springBoot1.library.dataBase.utils;

import springProject.springBoot1.library.model.Author;
import springProject.springBoot1.library.model.Book;
import springProject.springBoot1.library.repositories.AuthorRepository;
import springProject.springBoot1.library.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LibraryDatabaseManager {

    /**
     * Klasa obslugiwana przez Spring i Lombok
     *
     * @Component - mowi, ze klasa jest zarzadzana przez springa. Spring utworzy beama o nazwie taką jak nazwa klasy,
     * tylko z malej litery
     *
     * @AllArgsConstructor - to samo implementuje na podstawie pol, za pomoca stringa. Chociaz mi nie zaimplementowalo.
     *
     * @param bookRepository - pamietac zeby bylo prywatne.
     * @param authorRepository - pamietac zeby bylo prywatne.
     * <p>
     * Metody odpowiadają za akcje po stronie bazy danych.
     */

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public void addBookToDatabase(Book book) {
        bookRepository.save(book);
    }

    public void removeBookToDatabase(Book book) {
        bookRepository.delete(book);
    }

    public Iterable<Book> getAllBooksFromDatabase() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseGet(() -> null);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseGet(() -> null);
    }
}
