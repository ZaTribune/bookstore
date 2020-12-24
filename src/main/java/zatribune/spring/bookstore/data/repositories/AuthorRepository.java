package zatribune.spring.bookstore.data.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.bookstore.data.entities.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
