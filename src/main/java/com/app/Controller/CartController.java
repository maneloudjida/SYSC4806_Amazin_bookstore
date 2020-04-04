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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
public class CartController {

    @Autowired
    private BookRepository books;

    @Autowired
    private UserRepository users;



    @GetMapping("/cart")
    public String getCart(@ModelAttribute("userID") Integer uid, Model model)
    {
        User u = users.findById(uid).get();


        model.addAttribute("books", u.shoppingCart);
        model.addAttribute("userID",uid);
        model.addAttribute("totalCost", u.getCartTotal());
        return "cart";
    }

    @GetMapping("/addtoCart")//need user id!
    public String addtoCart(@ModelAttribute("bookID") Integer id, @ModelAttribute("userID") Integer uid,  Model model)
    {

        User u = users.findById(uid).get();
        Book b = books.findById(id).get();

        u.shoppingCart.add(b);

        users.save(u);

        model.addAttribute("books", u.shoppingCart);
        model.addAttribute("userID",uid);
        model.addAttribute("totalCost", u.getCartTotal());


        return "cart";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(@ModelAttribute("id") Integer id, @ModelAttribute("userID") Integer uid,  Model model)
    {

        User u = users.findById(uid).get();

        Book b = books.findById(id).get();

        u.shoppingCart.remove(b);
        users.save(u);

        model.addAttribute("books", u.shoppingCart);
        model.addAttribute("userID",uid);
        model.addAttribute("totalCost", u.getCartTotal());
        return "cart";
    }


    //This method is a place holder. Real purchasing would require the collection of shipping and billing info
    @PostMapping("/purchase")
    public String purchase(@ModelAttribute("userID") Integer uid,  Model model)
    {

        User u = users.findById(uid).get();

        Set<Book> set = new LinkedHashSet<Book>(u.purchases);
        set.addAll(u.shoppingCart);
        u.purchases = new ArrayList<>(set);

        double price = u.getCartTotal();
        List<Book> receipt = new ArrayList<>(u.shoppingCart);

        u.shoppingCart.clear();
        users.save(u);

        model.addAttribute("books", receipt);
        model.addAttribute("userID",uid);
        model.addAttribute("totalCost", price);
        return "purchaseReceipt";
    }

    @GetMapping("/purchased")
    public String purchased(@ModelAttribute("userID") Integer uid,  Model model)
    {
        User u = users.findById(uid).get();
        model.addAttribute("userID",uid);
        model.addAttribute("books",u.purchases);
        return "purchased";
    }
}
