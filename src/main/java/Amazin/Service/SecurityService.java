package Amazin.Service;

public interface SecurityService {
        String findLoggedInEmail();

        void autoLogin(String email, String password);
}
