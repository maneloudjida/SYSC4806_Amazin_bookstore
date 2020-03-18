/**
  * Removing the validator, working on it next iteration

package Amazin.Service;

import Amazin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component

 * This class validates if the users interaction with the system, more specifically the login and sign up section
 * We can add more restriction here, like if the email is actually a name not an email

public class UserValidator implements Validator {
    @Autowired
    private UserSignIn userService;

    @Override
    /**
     * This checks if the the userValidator is validating the User 

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    /**
     * Validates multiple user login and sign up functionalities

    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userService.findByUsername(user.getEmail()) != null) { //Checks if there<s 
            errors.rejectValue("email", "Duplicate.u.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.u.password");
        }
    }
}
**/