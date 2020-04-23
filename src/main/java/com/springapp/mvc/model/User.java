package com.springapp.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private Long userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String hobby;
    private Long credentialsId;

}