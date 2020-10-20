package com.springapp.mvc.dto;

public class UserDetailsDTO {

    private String userId;
    private String firstName;
    private String lastName;
    private String credentialsId;
    private String age;
    private String children;
    private String job;
    private String login;
    private String password;
    private String role;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

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

    public String getCredentialsId() { return credentialsId; }

    public void setCredentialsId(String credentialsId) { this.credentialsId = credentialsId; }

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public String getChildren() { return children; }

    public void setChildren(String children) { this.children = children; }

    public String getJob() { return job; }

    public void setJob(String job) { this.job = job; }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}
