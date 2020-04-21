package com.springapp.mvc.dto;

import com.springapp.mvc.model.User;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String dob;

    public UserDTO(User user) {
        this.id = user.getCredentialsId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dob = user.getDob();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
