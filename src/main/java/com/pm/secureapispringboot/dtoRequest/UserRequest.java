package com.pm.secureapispringboot.dtoRequest;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */



@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    @NotEmpty(message = "first name cannot be empty or null ")
    private String firstName;
    @NotEmpty(message = "last name cannot be empty or null ")
    private String lastName;
    @NotEmpty(message = "email account cannot be empty or null ")
    @Email(message = "Invalid email address")
    private String email;
    @NotEmpty(message = "password cannot be empty or null ")
    private String password;
    private String bio;
    private String phoneNumber;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
