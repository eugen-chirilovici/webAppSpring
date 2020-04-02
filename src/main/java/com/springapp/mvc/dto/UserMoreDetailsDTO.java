package com.springapp.mvc.dto;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.Stream;

public class UserMoreDetailsDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String hobby;
    private Stream stream;

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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public void setUserDTO(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.hobby = user.getHobby();
        this.stream = user.getStream();
    }
}
