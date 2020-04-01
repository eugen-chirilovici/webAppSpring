package com.springapp.mvc.dto;

import com.springapp.mvc.model.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String age;
    private String hobby;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setUser(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = String.valueOf(user.getAge());
        this.hobby = user.getHobby();
    }
}
