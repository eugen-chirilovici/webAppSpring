package com.springapp.mvc.utils;

import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;

import java.util.function.Function;

public class Converter {

    public final static Function<User, UserDTO> convertFromUserToUserDTO = user -> {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId().toString());
        userDTO.setCredentialsId(user.getCredentialsId().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(user.getAge());
        userDTO.setMarried(user.getMarried());
        return userDTO;
    };

    public final static Function<Credentials, CredentialsDTO> convertFromCredentialsToCredentialsDTO =
            credentials -> {
                CredentialsDTO credentialsDTO = new CredentialsDTO();
                credentialsDTO.setLogin(credentials.getLogin());
                credentialsDTO.setPassword(credentials.getPassword());
                credentialsDTO.setRole(credentials.getRole());

        return credentialsDTO;
    };
}
