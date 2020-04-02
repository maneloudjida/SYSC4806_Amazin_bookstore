package com.app.Controller;

import com.app.entity.Book;
import com.app.repository.BookRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BookController {

    @Autowired
    private BookRepository books;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/book")
    public String getBook(@ModelAttribute("id") Integer id, Model model)
    {
        Book bb = books.findById(id).get();
        model.addAttribute("book",bb);
        return "book";
    }




}