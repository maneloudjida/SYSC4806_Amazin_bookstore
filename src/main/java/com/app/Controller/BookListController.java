package com.app.Controller;

import com.app.entity.Book;
import com.app.repository.BookRepository;
import com.app.repository.UserRepository;
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

    @GetMapping("/getBooks")
    public String getBooks(Model model) {
        //model.addAttribute("shopCart");

        model.addAttribute("books", books.findAll());
        return "bookList";
    }

    @GetMapping("/search")
    public String getByName(@ModelAttribute("name")String name, Model model) {

        model.addAttribute("books", books.findByName(name));
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
