package com.springapp.mvc.util;

import com.springapp.mvc.model.User;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class UserUtils {
    public static User createUser() {
        return new User(17L, "Stefan", "Danila",
                17L, Date.valueOf("1998-03-10"), "sdanila@endava.com");
    }

    public static List<User> createListOfUsers() {
        final User user1 = new User(17L, "Stefan", "Danila",
                17L, Date.valueOf("1998-03-10"), "sdanila@endava.com");
        final User user2 = new User(20L, "Arnold", "Doe",
                20L, Date.valueOf("2000-07-15"), "aDoe@endava.com");
        return Arrays.asList(user1, user2);
    }
}
