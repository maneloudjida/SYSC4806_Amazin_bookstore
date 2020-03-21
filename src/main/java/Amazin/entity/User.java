package Amazin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Integer id;

    @Column(name = "fname")
    private string fname
  
    //@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    //public Cart shoppingCart;//will change to private later

    @Column(name = "lname")
    private String lname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "Role")
    //@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Role role;

    @Column(name = "username")
    private String username;

    @Column(name = "enabled")
    private  int enabled;

    public User() {
    }
    public User(String fname, String lname, String email, String password, Role role, String username, int enabled) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
        this.enabled = enabled;
        //shoppingCart = new Cart();
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
                getUsername().equals(user.getUsername()) &&
                getEnabled() == user.getEnabled();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getFname(), getLname(), getEmail(), getPassword(), getRole(), getUsername(), getEnabled());
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
    public void setRole(Role role) { this.role = role;}
    public int getEnabled(){return enabled; }
    public void setEnabled(int enabled){this.enabled = enabled;}

    public void addToCart(Book book){ shoppingCart.addToCart(book);}

}
