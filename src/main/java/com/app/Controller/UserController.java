package com.app.Controller;

import com.app.entity.Role;
import com.app.entity.User;
import com.app.repository.BookRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private BookRepository books;
    @Autowired
    UserRepository repository;

    @RequestMapping("/signup")
    public String index(Model model) {
        return "signup";
    }

    @RequestMapping(value="/newUser", method=RequestMethod.GET)
    public String newUser(@RequestParam("fname") String fname,
                          @RequestParam("lname") String lname,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("role") Role role, Model model){

        User u = new User();

        u.setFname(fname);
        u.setLname(lname);
        u.setEmail(email);
        u.setPassword(password);
        u.setRole(role);


        repository.save(u);



        model.addAttribute("books", books.findAll());

        return "bookList";
    }

}
