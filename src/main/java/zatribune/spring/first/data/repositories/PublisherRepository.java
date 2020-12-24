package zatribune.spring.first.data.repositories;

import org.springframework.data.repository.CrudRepository;
import zatribune.spring.first.data.entities.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
