package com.springapp.mvc.dto;

public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String credentialsId;
    private int age;
    private boolean married;

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

    public int getAge() { return age;
    }
    public void setAge(int age) { this.age = age; }

    public boolean getMarried() { return married; }

    public void setMarried(boolean maried) { this.married = maried; }


}
