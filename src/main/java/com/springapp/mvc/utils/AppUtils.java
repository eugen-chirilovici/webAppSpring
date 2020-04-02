package com.springapp.mvc.utils;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.User;

public class AppUtils {
    public static UserDTO convertUserToUserDTO(User user) {
        UserDTO userDto= new UserDTO();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setOrganization(user.getOrganization());
        userDto.setGender(user.getGender());
        return userDto;
    }

}
