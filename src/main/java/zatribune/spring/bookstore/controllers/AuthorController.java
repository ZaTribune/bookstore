package zatribune.spring.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zatribune.spring.bookstore.data.repositories.AuthorRepository;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    String getAuthorsView(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors";
    }
}
