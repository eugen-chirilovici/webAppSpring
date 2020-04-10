package com.springapp.mvc.utils;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtils {
    public User createUser() {
        User user = new User("fname", "Lname", 10L, "Hobby", "SomeMusic", 33);
        return user;
    }

    public List<User> createUserList() {
        User user1 = new User("testUser1", "testUser1", 11L, "Hobby",
                "SomeMusic", 33);

        User user2 = new User("testUser2", "testUser2", 11L, "Hobby",
                "SomeMusic", 33);


        return Arrays.asList(user1, user2);
    }
}
