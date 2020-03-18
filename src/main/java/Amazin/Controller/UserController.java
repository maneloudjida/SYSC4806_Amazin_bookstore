package Amazin.Controller;

import Amazin.Service.Security;
import Amazin.Service.UserSignIn;
//import Amazin.Service.UserValidator;
import Amazin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserSignIn userSignIn;

    @Autowired
    private Security security;

    /**
     * @Autowired
    private UserValidator userValidator;
     **/

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        /**
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
         */

        userSignIn.save(userForm);
        security.autoLogin(userForm.getEmail(), userForm.getPassword());
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

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}