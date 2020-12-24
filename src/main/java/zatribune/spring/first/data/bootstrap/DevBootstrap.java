package zatribune.spring.first.data.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import zatribune.spring.first.data.entities.Author;
import zatribune.spring.first.data.entities.Book;
import zatribune.spring.first.data.entities.Publisher;
import zatribune.spring.first.data.repositories.AuthorRepository;
import zatribune.spring.first.data.repositories.BookRepository;

// this is a bootstrap initialization class to initialize data on the DB
// used in a real common use-case like in (in-memory databases scenario e.g. h2 database)

@Component // this will make it a spring bean and it will get wired up by the spring context
// this class will be created and managed by the spring framework
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    // still after creating those objects  no auto-wiring is happening
    // as spring uses dependency injection
    //so that in runtime those classes  will be created and managed by the spring framework
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author author1 = new Author("Muhammad", "Ali");
        Book book1 = new Book("The old way", "255815");
        Publisher publisher1=new Publisher("ZaTribune","21,Tahrir Square,Zagazig");
        book1.setPublisher(publisher1);
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        /*
        ERROR:object references an unsaved transient instance - save the transient instance before flushing
        This happens because you have a collection in your entity,
        and that collection has one or more items which are not present in the database.
        By specifying the cascade options you tell hibernate to save them to the database when saving their parent.
         */
        Author author2 = new Author("Nora", "Suliman");
        Book book2 = new Book("Kids in upper Egypt", "266454");
        Publisher publisher2=new Publisher("Centurions","15,Gam3a Square,Nasr City");
        book2.setPublisher(publisher2);
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author1);
        bookRepository.save(book1);
        authorRepository.save(author2);
        bookRepository.save(book2);
     }

}
