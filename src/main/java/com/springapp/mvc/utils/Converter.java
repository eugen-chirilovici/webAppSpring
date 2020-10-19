package com.springapp.mvc.utils;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.User;

import java.util.function.Function;

public class Converter {

    public final static Function<User, UserDTO> convertFromUserToUserDTO = user -> {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId().toString());
        userDTO.setCredentialsId(user.getCredentialsId().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(String.valueOf(user.getAge()));
        userDTO.setHobby(user.getHobby());
        return userDTO;
    };

}
