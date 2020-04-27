package com.springapp.mvc.appConfiguration;

import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;

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
}
