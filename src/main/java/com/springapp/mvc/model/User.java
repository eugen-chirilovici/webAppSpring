package com.springapp.mvc.model;

public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private int age;
    private String hobby;
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

    public User(String firstName, String lastName, int age, String hobby, Long credentialsId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hobby = hobby;
        this.credentialsId = credentialsId;
    }

    public User(Long userId, String firstName, String lastName, int age, String hobby, Long credentialsId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hobby = hobby;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
