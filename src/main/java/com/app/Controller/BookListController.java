package com.app.Controller;

import com.app.entity.Book;
import com.app.entity.User;
import com.app.repository.BookRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookListController {
    @Autowired
    private BookRepository books;

    @Autowired
    private UserRepository users;

    @GetMapping("/getBooks")
    public String getBooks(@ModelAttribute("userID") Integer uid, Model model) {
        //model.addAttribute("shopCart");
        if (uid == null)
        {
            uid = 10;
        }

        List<Book> recommended = new ArrayList<Book>();
        Iterable<Book> allBooks  = books.findAll();
        User u = users.findById(uid).get();

        for (Book b : u.purchases)
        {
            for (Book c : allBooks)
            {
                if(b != c && !u.purchases.contains(c) && !recommended.contains(c))
                {
                    if (b.getAuthor() == c.getAuthor() || b.getGenre() == c.getGenre())
                    {
                        recommended.add(c);
                    }
                }
            }
        }


        model.addAttribute("recommendedbooks", recommended);



        model.addAttribute("role",u.getRole().toString());
        model.addAttribute("books", books.findAll());
        model.addAttribute("userID",uid);

        return "bookList";
    }

    @GetMapping("/search")
    public String getByName(@ModelAttribute("userID") Integer uid, @ModelAttribute("name")String name, Model model) {
        User u = users.findById(uid).get();
        model.addAttribute("books", books.findByName(name));
        model.addAttribute("role",u.getRole());
        model.addAttribute("userID",uid);
        return "bookList";
    }

    @GetMapping("/getBook")
    public String getInputBook(@ModelAttribute("userID")Integer uid, Model model) {

        model.addAttribute("userID",uid);
        model.addAttribute("newBook", new Book());
        return "getBook";
    }

    @PostMapping("/getBook")
    public String gotBook(@ModelAttribute("userID")Integer uid, @ModelAttribute("newBook") Book newBook,
                          Model model
    ) {
        books.save(newBook);

        return getBooks(uid,model);
    }
}
