package zatribune.spring.bookstore.data.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.bookstore.data.entities.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
