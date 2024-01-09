package by.teachmeskills.lesson40.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    @NotBlank(message = "Enter a Name")
    private String name;
    @Size(min = 1, max = 10, message = "Password should be from 1 to 10 symbols")
    private String password;
    @Email
    private String email;
    public User() {
    }
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
