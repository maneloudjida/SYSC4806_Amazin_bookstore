package com.app.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER)
    public List<Book> shoppingCart = new ArrayList<Book>();;//will change to private later

    @OneToMany()
    public List<Book> purchases = new ArrayList<Book>();

    private String fname;
    private String lname;
    private String email;
    private String password;

    //@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Role role;

    public User() {

    }
    public User(String fname, String lname, String email, String password, Role role) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.role = role;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                getId().equals(user.getId()) &&
                getFname().equals(user.getFname()) &&
                getLname().equals(user.getLname()) &&
                getEmail().equals(user.getEmail()) &&
                getPassword().equals(user.getPassword()) &&
                getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getFname(), getLname(), getEmail(), getPassword(), getRole());
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public double getCartTotal()
    {
        double retVal = 0;
        for (Book b : shoppingCart)
        {
            retVal += b.getCost();
        }
        return retVal;
    }

}
