package com.springapp.mvc.utils;

import com.springapp.mvc.dto.UserRegistDTO;

public class UserRegistDTOUtils {
    public UserRegistDTO createUserRegistDto() {
        UserRegistDTO userRegistDTO = new UserRegistDTO("fname","lName", "login",
                "password", "hobby", "music_p",30);
        return userRegistDTO;
    }
}
