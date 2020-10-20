package com.springapp.mvc.model;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

public class User {
    private Long userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Long credentialsId;
    @NotNull
    private String hobby;
    @NotNull
    private int age;

    public User(String firstName, String lastName, Long credentialsId, String hobby, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.hobby = hobby;
        this.age = age;
    }

    public User(Long userId, String firstName, String lastName, Long credentialsId,String hobby, int age) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentialsId = credentialsId;
        this.hobby = hobby;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
