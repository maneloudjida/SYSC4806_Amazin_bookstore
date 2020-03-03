package Controller;

import entity.Book;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import repository.BookRepository;
import repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes("books")
public class BookController {

    @Autowired
    private BookRepository books;
    @Autowired
    private UserRepository userRepository;

    public List<Book> getBooks() {
        return books.findAll();
    }


    public void setBooks(BookRepository books) {
        this.books = books;
    }


   /*
    @GetMapping("/addbook")
    TO BE CONTINUED
    public Book addBook(Book book , Principal principal) {
        String username = principal.getName();
        User user =  userRepository.findByUsername(username).get();


    }
    */

/*
*Method to add: addBook
*
 */

    /*
     *Method to add: removeBook
     *
     */

}
