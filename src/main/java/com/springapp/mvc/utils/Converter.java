package com.springapp.mvc.utils;

import java.util.function.Function;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.User;

public class Converter {

    public final static Function<User, UserDTO> convertFromUserToUserDTO = user -> {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId().toString());
        userDTO.setCredentialsId(user.getCredentialsId().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setNickname(user.getNickname());
        userDTO.setBirthday(user.getBirthday());
        return userDTO;
    };

}
