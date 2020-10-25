package com.springapp.mvc.model;

public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private Long credentialsId;
    private String email;
    private String birthdate;

    public User(String firstName, String lastName, Long credentialsId, String email, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.email = email;
        this.birthdate = birthdate;
    }

    public User(Long userId, String firstName, String lastName, Long credentialsId, String email, String birthdate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.email = email;
        this.birthdate = birthdate;
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
