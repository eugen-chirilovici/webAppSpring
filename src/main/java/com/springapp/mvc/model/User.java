package com.springapp.mvc.model;

public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private Long credentialsId;
    private Integer age;
    private Integer children;
    private String job;

    public User(String firstName, String lastName, Long credentialsId, Integer age, Integer children, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.age = age;
        this.children = children;
        this.job = job;
    }

    public User(String firstName, String lastName, Long credentialsId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
    }

    public User(Long userId, String firstName, String lastName, Long credentialsId, Integer age, Integer children, String job) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.age = age;
        this.children = children;
        this.job = job;
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

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public Integer getChildren() { return children; }

    public void setChildren(Integer children) { this.children = children; }

    public String getJob() { return job; }

    public void setJob(String job) { this.job = job; }
}
