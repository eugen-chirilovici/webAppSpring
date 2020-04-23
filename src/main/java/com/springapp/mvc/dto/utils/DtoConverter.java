package com.springapp.mvc.dto.utils;

import com.springapp.mvc.dto.UserMoreDetailsDTO;
import com.springapp.mvc.model.User;

public class DtoConverter {

    public static UserMoreDetailsDTO convertUserToDto(User user){
        UserMoreDetailsDTO userDTO = new UserMoreDetailsDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setHobby(user.getHobby());
        userDTO.setLastName(user.getLastName());
        userDTO.setStream(user.getStream());
        return userDTO;

    }
}
