package model.entities;

import java.util.Date;
import java.util.Objects;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Date birthDate;

    public User() {
    }

    public User(Integer id, String username, String email, Date birthDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
    }

    public User(Integer id, String username, String email, String password, Date birthDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
