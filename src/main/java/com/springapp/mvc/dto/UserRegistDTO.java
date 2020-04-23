package com.springapp.mvc.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class UserRegistDTO {
    private String firstName;
    private String lastName;
    private String age;
    private String hobby;
    private String password;
    private String username;
}
