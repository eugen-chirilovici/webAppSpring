package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersDAO {

    private static long id = 0L;
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L, Date.valueOf("1997-03-10"), "echirilovici@endava.com"));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L, Date.valueOf("1995-05-15"), "cnicuta@endava.com"));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L, Date.valueOf("1994-06-01"), "frosca@endava.com"));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(), user.getBirthDate(), user.getEmail()));
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
        UsersDAO.listOfUsers = listOfUsers;
    }

    public List<User> findUserByCredentialsId(long credentialsId) {
            return listOfUsers.stream()
                    .filter(t -> t.getCredentialsId().equals(credentialsId))
                    .collect(Collectors.toList());
    }
}
