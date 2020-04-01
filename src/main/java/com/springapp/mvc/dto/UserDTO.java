package com.springapp.mvc.dto;

import com.springapp.mvc.model.User;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String organization;
    private String gender;

    public void setUser(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.organization = user.getOrganization();
        this.gender = user.getGender();
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
