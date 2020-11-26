package springProject.springBoot1.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * @JoinColumn - kolumna z kluczem obcym
 * cascade = CascadeType.PERSIST - gdy zapisujemy ksiazke do db to auto zapisany zostaje tez jej autor
 * private Author author; - musi byc identyczne z mappedBy = "author" (Z Author),
 *
 * equals i hashcode zawsze razem do porownywania i rozrozniania obiektow (automatycznie generowane)
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
