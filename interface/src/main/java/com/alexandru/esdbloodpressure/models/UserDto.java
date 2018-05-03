package com.alexandru.esdbloodpressure.models;

import com.alexandru.esdbloodpressure.annotations.FieldsValueMatch;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
//costum annotation for verifying password and email field match
@FieldsValueMatch.List({
    @FieldsValueMatch(
            field = "password",
            fieldMatch = "passVerify",
            message = "Passwords do not match!"
    )
    , 
    @FieldsValueMatch(
            field = "email",
            fieldMatch = "emailVerify",
            message = "Email addresses do not match!"
    )
})
public class UserDto {

    @NotBlank(message = "First name is required")
    @Size(min = 1, max = 20, message = "First name should be between 1 and 20 characters long.")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 1, max = 20, message = "Last name should be between 1 and 20 characters long.")
    private String lastName;

    @NotBlank(message = "Please choose a username")
    @Size(min = 3, max = 10, message = "User name should be between 3 and 10 characters long")
    private String username;

    @NotBlank(message = "Please choose a password")
    @Size(min = 3, max = 20, message = "Password should be between 3 and 20 characters long")
    private String password;

    private String passVerify;

    @NotBlank(message = "Please type your email address")
    @Email(message = "Make sure to enter a valid email address")
    private String email;

    private String emailVerify;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String username, String password, String passVerify, String email, String emailVerify, List<Authority> authorities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.passVerify = passVerify;
        this.email = email;
        this.emailVerify = emailVerify;
    }

    public String getEmailVerify() {
        return emailVerify;
    }

    public void setEmailVerify(String emailVerify) {
        this.emailVerify = emailVerify;
    }

    public String getPassVerify() {
        return passVerify;
    }

    public void setPassVerify(String passVerify) {
        this.passVerify = passVerify;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDto{" + "firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", passVerify=" + passVerify + ", email=" + email + ", emailVerify=" + emailVerify + '}';
    }

}
