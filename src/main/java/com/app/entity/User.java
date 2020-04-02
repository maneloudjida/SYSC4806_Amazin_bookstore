package com.app.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public Cart shoppingCart;//will change to private later

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
        shoppingCart = new Cart();
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

    public void addToCart(Book book){ shoppingCart.addToCart(book);}

}
