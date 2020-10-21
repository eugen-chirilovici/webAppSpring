package com.springapp.mvc.utils;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.dto.UserDetailsDTO;
import com.springapp.mvc.model.User;

import java.util.function.Function;

public class Converter {

    public final static Function<User, UserDTO> convertFromUserToUserDTO = user -> {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId().toString());
        userDTO.setCredentialsId(user.getCredentialsId().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    };

    public final static Function<User, UserDetailsDTO> convertFromUserToUserDetailsDTO = user -> {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setUserId(user.getUserId().toString());
        userDetailsDTO.setFirstName(user.getFirstName());
        userDetailsDTO.setLastName(user.getLastName());
        userDetailsDTO.setCredentialsId(user.getCredentialsId().toString());
        userDetailsDTO.setAge(user.getAge().toString());
        userDetailsDTO.setChildren(user.getChildren().toString());
        userDetailsDTO.setJob(user.getJob());
        return userDetailsDTO;
    };
}
