package com.springapp.mvc.model;

public class User {

    private Long userId;

    private String firstName;

    private String lastName;

    private Long credentialsId;

    private String nickname;

    private String birthday;

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

    public User(final Long userId, final String firstName, final String lastName, final Long credentialsId, final String nickname, final String birthday) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.nickname = nickname;
        this.birthday = birthday;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(final String birthday) {
        this.birthday = birthday;
    }
}
