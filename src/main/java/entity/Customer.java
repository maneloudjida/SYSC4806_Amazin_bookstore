package entity;

import java.util.ArrayList;

public class Customer extends User{

    public Customer(Long iD, String userId, String fname, String lname, String email, String password, String passconfirm, Role role) {
        super(iD, userId, fname, lname, email, password, passconfirm, role);
        this.setRole(Role.ROLE_CUSTOMER);
    }

}
