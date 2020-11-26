package springProject.springBoot1.library.model;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Author {

    /**
     * @Entity - opisuje klase, której obiekt ma przedstawiac rekord w tabeli bazodanowej
     * @NoArgsConstructor - lombok, tworzy konstruktor.
     * @Id - wskazuje ze dane pole jest unikalnym identyfikatorem dla obiektu tej klasy.
     * @GenerateValue - wskazuje ze id jest generowany automatycznie w momencie zapisu do bazy danych
     * @OneToMany - relacja jeden do wielu
     * orphanRemoval - jezeli usuniemy ksiazke, ktora powiazana jest z autorem z kolekcji books,
     * to zostanie to odzwierciedlone na bazie danych. Obiekty podrzedne moga istniec bez nadrzednych.
     * cascade - mowi o tym, ze chcielibysmy podczas zapisu obiektu typu autor, automatycznie zapisac wszystkie ksiazki
     * nalezace do danego autora.
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private Set<Book> books = new HashSet<>();

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
