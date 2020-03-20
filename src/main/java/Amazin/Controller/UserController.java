package Amazin.Controller;

import Amazin.entity.User;
import Amazin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserRepository users;

    /**@Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("errorMsg", "Incorrect Account information");
        if (logout != null)
            model.addAttribute("msg", "Logged Out");

        return "login";
    }

    /**@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegister(@ModelAttribute("user") UserRegistration userRegistrationObject) {

        User user = new User(userRegistrationObject.getUsername(), userRegistrationObject.getPassword(), authorities);
        jdbcUserDetailsManager.createUser(user);
        return new ModelAndView("redirect:/bookList");
    }*/
}
