package Amazin.Controller;

import Amazin.entity.Book;
import Amazin.repository.BookRepository;
import Amazin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookListController {
    @Autowired
    private BookRepository books;

    @Autowired
    private UserRepository users;

    @GetMapping("/")
    public String getBooks(Model model) {

        model.addAttribute("books", books.findAll());
        return "bookList";
    }

    @GetMapping("/getBook")
    public String getInputBook(Model model) {

        model.addAttribute("newBook", new Book());
        return "getBook";
    }

    @PostMapping("/getBook")
    public String gotBook(@ModelAttribute("newBook") Book newBook,
                          Model model
    ) {
        books.save(newBook);

        return getBooks(model);
    }
}
