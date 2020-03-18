package Amazin.Service;

/**
 * Interface of the security service
 */
public interface Security {
        /**
         * This find the user that is logged
         * @return logged in User
         */
        String findLoggedInEmail();

        /**
         * This method automatically makes a user sign in if the user is authenticated
         * @param email is the email key
         * @param password is the password
         * Both parameters are from the specific user
         */
        void autoLogin(String email, String password);
}
