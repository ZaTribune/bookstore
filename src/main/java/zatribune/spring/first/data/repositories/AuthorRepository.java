package zatribune.spring.first.data.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.first.data.entities.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
