package com.app.Controller;

import com.app.entity.Book;
import com.app.entity.User;
import com.app.repository.BookRepository;
import com.app.repository.CartRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CartController {

    @Autowired
    private BookRepository books;

    @Autowired
    private UserRepository users;

    @Autowired
    private CartRepository carts;

    @GetMapping("/cart")
    public String getCart(@ModelAttribute("id") Integer id, Model model)
    {
        //Code to show users cart
        return "cart";
    }

    @GetMapping("/addtoCart")//need user id!
    public String addtoCart(@ModelAttribute("bookID") Integer id,  Model model)
    {
        Book b = books.findById(id).get();
        
        User u = (User) users.findByfname("Kyle");
        u.addToCart(b);

        model.addAttribute("cartinfo", u.shoppingCart.toString());
        return "cart";
    }


}
