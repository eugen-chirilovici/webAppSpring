package com.springapp.mvc.utils;

import com.springapp.mvc.dto.DetUserDTO;
import com.springapp.mvc.model.User;

public class AppUtils {
    public static DetUserDTO convertUserToUserDTO(User user) {
        DetUserDTO detUserDTO= new DetUserDTO();
        detUserDTO.setFirstName(user.getFirstName());
        detUserDTO.setLastName(user.getLastName());
        detUserDTO.setAge(user.getAge());
        detUserDTO.setGender(user.getGender());
        return detUserDTO;
    }
}
