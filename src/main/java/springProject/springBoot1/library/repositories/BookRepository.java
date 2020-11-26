package springProject.springBoot1.library.repositories;

import springProject.springBoot1.library.model.Book;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
