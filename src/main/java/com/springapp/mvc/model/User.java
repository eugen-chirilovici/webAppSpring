package com.springapp.mvc.model;

public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private Long credentialsId;
    private int age;
    private String zodiacSign;

    public User(String firstName, String lastName, Long credentialsId,int age, String zodiacSign) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.age=age;
        this.zodiacSign=zodiacSign;
    }

    public User(Long userId, String firstName, String lastName, Long credentialsId,int age, String zodiacSign) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.age=age;
        this.zodiacSign=zodiacSign;
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

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getZodiacSign() { return zodiacSign; }

    public void setZodiacSign(String zodiacSign) { this.zodiacSign = zodiacSign; }
}
