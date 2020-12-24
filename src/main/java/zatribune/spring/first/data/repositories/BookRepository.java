package zatribune.spring.first.data.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.first.data.entities.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
