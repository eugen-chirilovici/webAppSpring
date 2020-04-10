package com.springapp.mvc.model;

import java.util.Date;

public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private Long credentialsId;
    private Date birthDate;
    private String email;

    public User(String firstName, String lastName, Date birthDate, String email, Long credentialsId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.credentialsId = credentialsId;
    }

    public User(Long userId, String firstName, String lastName, Long credentialsId, Date birthDate, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(Long credentialsId) {
        this.credentialsId = credentialsId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credentialsId=" + credentialsId +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                '}';
    }
}
