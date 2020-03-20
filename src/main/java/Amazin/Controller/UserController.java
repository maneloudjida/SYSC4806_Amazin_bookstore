package Amazin.Controller;

import Amazin.Service.Security;
import Amazin.Service.UserSignIn;
//import Amazin.Service.UserValidator;
import Amazin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Configuration
public class UserController {
    @Autowired
    private UserSignIn userSignIn;

    @Autowired
    private Security security;

    /**
     * @Autowired
    private UserValidator userValidator;
     **/

    @GetMapping("/signIn")
    public String signIn(Model model) {
        model.addAttribute("newUser", new User());

        return "signIn";
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody User newUser, BindingResult bindingResult) {
        /**
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "signIn";
        }
         */

        userSignIn.save(newUser);
        security.autoLogin(newUser.getEmail(), newUser.getPassword());
        return "redirect:/welcome";
    }

    /**
     * The Get functionality for the login
     * There is already a Post functionality already built in with
     */
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/home"})
    public String welcome(Model model) {
        return "home";
    }
}