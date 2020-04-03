package com.springapp.mvc.dto;

import com.springapp.mvc.model.User;

import javax.jws.soap.SOAPBinding;

public class UserDataParser {
    private String firstName;
    private String lastName;
    private String hobby;
    private String musicPreferences;
    private String age;

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

    public String getAge() {
        return String.valueOf(age);
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserDataParser parser(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.hobby = user.getHobby();
        this.musicPreferences = user.getMusicPreferences();
        this.age = String.valueOf(user.getAge());
        return this;
    }
}