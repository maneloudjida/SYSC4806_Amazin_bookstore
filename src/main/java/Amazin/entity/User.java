package Amazin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String fname;

    private String lname;

    private String email;

    private String password;

    private Role role;

    private String username;

    public User() {
    }
    public User(String fname, String lname, String email, String password, Role role, String username) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
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
                getRole() == user.getRole() &&
                getUsername() == user.getUsername();
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
    public void setPassword(String password) { this.password = password;}
    public String getUsername() { return username; }
    public void setUsername(String username) {this.username = username; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

}
