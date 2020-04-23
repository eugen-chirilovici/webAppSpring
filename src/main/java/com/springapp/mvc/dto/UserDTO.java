package com.springapp.mvc.dto;

import com.springapp.mvc.model.User;
import lombok.Data;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    private String age;
    private String hobby;

    public void setUser(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = String.valueOf(user.getAge());
        this.hobby = user.getHobby();
    }
}
