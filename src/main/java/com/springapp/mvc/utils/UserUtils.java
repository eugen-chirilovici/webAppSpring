package com.springapp.mvc.utils;

import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;

import java.util.List;

import static java.util.Arrays.asList;

public class UserUtils {

    public static User createUser() {
        return User.builder().credentialsId(0L)
                .firstName("Eugen")
                .lastName("Chirilovici")
                .dob("15 sept 1997")
                .build();
    }

    public static List<User> createListOfUsers() {
        final User user1 = User.builder().credentialsId(0L)
                .firstName("Eugen")
                .lastName("Chirilovici")
                .dob("15 sept 1997")
                .build();

        final User user2 = User.builder().credentialsId(1L)
                .firstName("Vasya")
                .lastName("Pupkin")
                .dob("15 sept 1990")
                .build();

        final User user3 = User.builder().credentialsId(3L)
                .firstName("John")
                .lastName("Doe")
                .dob("11 sept 2001")
                .build();

        return asList(user1, user2, user3);
    }

    public static Credentials createCredentials() {
        return Credentials.builder().id(0L)
                .login("echirilovici")
                .password("test")
                .role(RoleType.ROLE_ADMIN)
                .build();
    }

}
