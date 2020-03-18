package Amazin.Controller;

import Amazin.Service.SecurityService;
import Amazin.Service.UserService;
import Amazin.Service.UserValidator;
import Amazin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signIn")
    public String signIn(Model model){
        model.addAttribute("u", new User());
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signIn(@ModelAttribute("u") User u, BindingResult bindingResult){
        userValidator.validate(u, bindingResult);

        if (bindingResult.hasErrors()){
            return "signIn";
        }
        userService.save(u);
        securityService.autoLogin(u.getEmail(), u.getPassword());
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){
        if (error != null)
            model.addAttribute("error", "Email and password incorrect.");

        if(logout != null)
            model.addAttribute("message", "Logged out");

        return "login";
    }

    @GetMapping({"/", "/home"})
    public String home(Model model){
        return "home";
    }


}
