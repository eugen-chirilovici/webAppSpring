package com.springapp.mvc.model;

public class User {
    private String organization;
    private String gender;
    private Long userId;
    private String firstName;
    private String lastName;
    private Long credentialsId;

    public User(String firstName, String lastName, Long credentialsId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
    }

    public User(Long userId, String firstName, String lastName, Long credentialsId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
    }

    public User(String firstName, String lastName, String organization, String gender, Long credentialsId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
        this.gender = gender;
        this.credentialsId = credentialsId;
    }

    public User(Long userId, String firstName, String lastName, String organization, String gender, Long credentialsId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
        this.gender = gender;
        this.credentialsId = credentialsId;
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
