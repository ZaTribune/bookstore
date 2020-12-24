package zatribune.spring.bookstore.data.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.bookstore.data.entities.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
