package springProject.springBoot1.library.repositories;

import springProject.springBoot1.library.model.Author;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
