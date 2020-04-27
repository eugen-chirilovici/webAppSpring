package com.springapp.mvc.dto;

import com.springapp.mvc.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {
    private String fname;
    private String lname;
    private String dob;

    public void setUser(User user) {
        this.fname = user.getFirstName();
        this.lname = user.getLastName();
        this.dob = user.getDob();
    }
}
