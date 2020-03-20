package Amazin.entity;

import  org.assertj.core.api.Assert;

import static org.junit.jupiter.api.Assertions.*;
public class UserTest {
    User user;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.user= new User("Kyle", "Smith", "kyle@yahoo.com", "hel", Role.ROLE_CUSTOMER, "KSmith");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getFname(){
        assertEquals(user.getFname(),"Kyle");
    }
    @org.junit.jupiter.api.Test
    void setFname(){
        user.setFname("adi");
        assertEquals(user.getFname(),"adi");
    }
    @org.junit.jupiter.api.Test
    void getLname(){
        assertEquals(user.getLname(),"Smith");
    }
    @org.junit.jupiter.api.Test
    void setLname(){
        user.setLname("Meet");
        assertEquals(user.getLname(),"Meet");
    }
    @org.junit.jupiter.api.Test
    void getPassword(){
        assertEquals(user.getPassword(),"hel");
    }
    @org.junit.jupiter.api.Test
    void setPassword(){
        user.setPassword("Meet");
        assertEquals(user.getPassword(),"Meet");
    }
    @org.junit.jupiter.api.Test
    void getRole(){
        assertEquals(user.getRole(),Role.ROLE_CUSTOMER);
    }
    @org.junit.jupiter.api.Test
    void setRole(){
        user.setRole(Role.ROLE_BOOKSTOREOWNER);
        assertEquals(user.getRole(),Role.ROLE_BOOKSTOREOWNER);
    }
    @org.junit.jupiter.api.Test
    void getUsername(){
        assertEquals(user.getUsername(),"KSmith");
    }
    @org.junit.jupiter.api.Test
    void setUsername() {
        user.setUsername("KSmith1");
        assertEquals(user.getUsername(), "KSmith1");
    }
}
