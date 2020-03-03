package entity;

import java.util.Objects;

public class User {
    private Long iD;
    private String userId;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String passconfirm;

    private Role role;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(Long iD, String userId, String fname, String lname, String email, String password, String passconfirm, Role role) {
        this.iD = iD;
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.passconfirm = passconfirm;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(iD, user.iD) &&
                getUserId().equals(user.getUserId()) &&
                getFname().equals(user.getFname()) &&
                getLname().equals(user.getLname()) &&
                getEmail().equals(user.getEmail()) &&
                getPassword().equals(user.getPassword()) &&
                getPassconfirm().equals(user.getPassconfirm()) &&
                getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(iD, getUserId(), getFname(), getLname(), getEmail(), getPassword(), getPassconfirm(), getRole());
    }

    public Long getiD() { return iD; }
    public void setiD(Long iD) { this.iD = iD; }
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
    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

}
