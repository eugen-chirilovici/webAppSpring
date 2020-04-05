package com.springapp.mvc.validation;

import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.RegisterService;
import com.springapp.mvc.service.UserService;

import java.util.List;

public class Validation {

    public static boolean validUser(User user){
        return user != null;
    }

    public static boolean incorrectCredentials(Credentials credentials){
        return credentials == null;
    }

    public static boolean stringValidation(String string){
        return !string.trim().isEmpty();
    }

    public static boolean ageValidation(int age){
        return age > 0 && age < 120;
    }

    public static boolean passwordValidation(String password){
        return stringValidation(password) && password.length() >= 4;
    }

    public static boolean loginValidation(RegisterService registerService, String login){
        return (!registerService.findIfLoginExist(login)) && stringValidation(login);
    }

    public static boolean registerValidation(UserRegistDTO userRegistDTO){
         return stringValidation(userRegistDTO.getFirstName()) &&
                stringValidation(userRegistDTO.getLastName()) &&
                stringValidation(userRegistDTO.getHobby()) &&
                passwordValidation(userRegistDTO.getPassword()) &&
                ageValidation(userRegistDTO.getAge());
    }

}
