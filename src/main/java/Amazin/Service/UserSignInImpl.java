package Amazin.Service;

import Amazin.entity.User;
import Amazin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
/**
 * This class saves a new user, while decrypting the users account
 */
public class UserSignInImpl implements UserSignIn {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    /**
     * Using the bCryptPasswordEncoder
     * Used to encode the password
     */
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    /**
     * Checks if there the email is in the repository already
     */
    public User findByUsername(String email) {
        return userRepository.findByEmail(email);
    }
}