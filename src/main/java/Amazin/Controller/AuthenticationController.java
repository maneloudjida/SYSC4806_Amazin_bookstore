package Amazin.Controller;


import Amazin.entity.User;
import Amazin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import java.util.List;

@Controller
public class AuthenticationController {


    private UserRepository repository;
    private int nextSession = 0;

    @Autowired
    public void setRepository(UserRepository repository){
        this.repository = repository;
    }



    @RequestMapping(value="/signin",method= RequestMethod.GET)
    public String checkUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Model model,
                            HttpServletResponse response){

        List<User> users = repository.findByemail(email);

        /*
        Verify if the user list from database is empty
        If list is empty - meaning the user did not sign up - lauch error page
         */

        if(users.isEmpty()){
            model.addAttribute("message", "User not found");
            return "loginError";
        }


        /*Take the first user from the list
        Only 1 email per user so list length should be 1
         */
        User u = users.get(0);

        /*
        Verify the password:
        If password wrong - launch error page with forgot password or signup link
        If password right - launch mainMenu page
         */

        if(u.getPassword().equals(password)){
            repository.save(u);
            return "mainPage";
        } else {

            model.addAttribute("message", "Password incorrect");
            return "loginPassForgot";
        }
    }


    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(Model model,
                         HttpServletResponse response){

        response.addCookie(new Cookie("sessionId",null));
        return "signin";
    }


    @RequestMapping(value="/signin",method=RequestMethod.GET)
    public String signins(){
        return "signin";
    }

    @RequestMapping(value="/mainPage",method=RequestMethod.GET)
    public String mainPage(){
        return "mainPage";
    }


}
