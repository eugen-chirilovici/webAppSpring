package com.springapp.mvc.dto;

public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String credentialsId;
    private String age;
    private String zodiacSign;

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

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public String getZodiacSign() { return zodiacSign; }

    public void setZodiacSign(String zodiacSign) { this.zodiacSign = zodiacSign; }
}
