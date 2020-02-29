package entity;

import java.util.Objects;

public class User {

    private String userId;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String passconfirm;
    //private Role roles; create new class that has the different roles
    //such as author, client...


    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(String userId, String fname, String lname, String email, String password, String passconfirm) {
        super();
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.passconfirm = passconfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(fname, user.fname) &&
                Objects.equals(lname, user.lname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(passconfirm, user.passconfirm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fname, lname, email, password, passconfirm);
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
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
    public String getPassconfirm() {
        return passconfirm;
    }
    public void setPassconfirm(String passconfirm) {
        this.passconfirm = passconfirm;
    }


}
