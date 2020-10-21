package com.springapp.mvc.utils;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class Converter {




    public final static Function<User, UserDTO> convertFromUserToUserDTO = user -> {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId().toString());
        userDTO.setCredentialsId(user.getCredentialsId().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhone(user.getPhoneNumber());
        return userDTO;
    };

}
