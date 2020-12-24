package zatribune.spring.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zatribune.spring.bookstore.data.repositories.BookRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //now . we create a function that returns a string of the view name by passing it a model
    // we'll associate this method with the books path
    @RequestMapping("/books")//the path to the resource
    String getBooksView(Model model){
         model.addAttribute("books",bookRepository.findAll());
         // this will associate this model with a thymeleaf view called "all books", so we giving it a view name
         return "books";//the name of the MCV view e.g. the thymeleaf template
    }

    // thymeleaf is a java template engine alternative to the JSP
    //it's natural meaning that you can view the pages naturally on the browser
}
