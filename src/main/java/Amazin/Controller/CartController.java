package Amazin.Controller;

import Amazin.entity.Book;
import Amazin.entity.User;
import Amazin.repository.BookRepository;
import Amazin.repository.UserRepository;
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

    @GetMapping("/cart")
    public String getCart(@ModelAttribute("id") Integer id, Model model)
    {
        //Code to show users cart
        return "cart";
    }

    @GetMapping("/addtoCart")//need user id!
    public String addtoCart(@ModelAttribute("id") Integer id, Model model)
    {
        Book b = books.findById(id).get();
        User u = users.findById(id).get();
        u.addToCart(b);
        model.addAttribute("cartinfo", u.shoppingCart.toString());
        return "cart";
    }


}
