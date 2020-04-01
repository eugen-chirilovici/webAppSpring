package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.Stream;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersDAO {

    private static long id = 0L;
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L));
        listOfUsers.add(new User(id++,"Denis","Gurduza",3L, Stream.JAVA,"cosmos"));
        listOfUsers.add(new User(id++,"Leo","L",4L, Stream.DOT_NET,"cars"));
        listOfUsers.add(new User(id++,"Andrei","I",5L, Stream.DEV_OPS,"swimming"));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId()));
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
