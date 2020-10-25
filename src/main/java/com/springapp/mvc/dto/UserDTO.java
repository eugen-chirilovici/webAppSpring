package com.springapp.mvc.dto;

public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String credentialsId;
    private String email;
    private String birthdate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(final String credentialsId) {
        this.credentialsId = credentialsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
