package Amazin.Service;

import Amazin.entity.User;

/**
 * This interface is used in the controller in order to sign user up
 */
public interface UserSignIn {
    /**
     * This method saves the users information
     * @param user is the User that wants to be saved to the repository
     */
    void save(User user);

    /**
     * This method returns a users information if it already exists in the repository
     * @param email checks with the unique key 'email'
     * @return User
     */
    User findByUsername(String email);
}
