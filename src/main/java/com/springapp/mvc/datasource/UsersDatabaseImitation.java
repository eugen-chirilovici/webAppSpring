package com.springapp.mvc.datasource;

import com.springapp.mvc.model.Genders;
import com.springapp.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDatabaseImitation {
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User("Mila Bezaliuc", "endava", Genders.FEMALE));
        listOfUsers.add(new User("Petru Covaliov", "endava", Genders.MALE));
        listOfUsers.add(new User("Maxim Ustimov", "endava", Genders.MALE));
    }

    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<User> listOfUsers) {
        UsersDatabaseImitation.listOfUsers = listOfUsers;
    }
}
