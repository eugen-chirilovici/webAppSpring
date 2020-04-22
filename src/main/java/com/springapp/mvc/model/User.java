package com.springapp.mvc.model;

public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private Long credentialsId;
    private String hobby;
    private String musicPreferences;
    int age;
    public User(String firstName, String lastName, Long credentialsId, String  hobby, String musicPreferences, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.hobby = hobby;
        this.musicPreferences = musicPreferences;
        this.age = age;
    }

    public User(Long userId, String firstName, String lastName, Long credentialsId, String hobby, String musicPreferences, int age) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.hobby = hobby;
        this.musicPreferences = musicPreferences;
        this.age = age;
    }


    public User(Long userId, String firstName, String lastName, String hobby, String musicPreferences, int age) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobby = hobby;
        this.musicPreferences = musicPreferences;
        this.age = age;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getMusicPreferences() {
        return musicPreferences;
    }

    public void setMusicPreferences(String musicPreferences) {
        this.musicPreferences = musicPreferences;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
