package com.springapp.mvc.datasource;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDB {

    private static long id = 0L;
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", RoleType.ROLE_ADMIN));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", RoleType.ROLE_USER));
        listOfUsers.add(new User(id++, "Filip", "Rosca", RoleType.ROLE_USER));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), RoleType.ROLE_USER));
        return userId;
    }

    public User findUserById(Long userId) {
        for (User user : listOfUsers) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<User> listOfUsers) {
        UsersDB.listOfUsers = listOfUsers;
    }
}
