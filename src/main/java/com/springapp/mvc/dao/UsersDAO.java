package com.springapp.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springapp.mvc.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UsersDAO {

    private static long id = 0L;

    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L, "EugenC", "1997/04/01"));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L, "CiprianN", "1997/04/01"));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L, "FilipR", "1997/04/01"));
        listOfUsers.add(new User(id++, "Ana", "Ann", 3L, "AnnC", "1997/04/01"));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(), user.getNickname(), user.getBirthday()));
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

    public List<User> findUserByCredentialsId(long credentialsId) {
        return listOfUsers.stream()
                .filter(t -> t.getCredentialsId().equals(credentialsId))
                .collect(Collectors.toList());
    }

    public static List<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(List<User> listOfUsers) {
        UsersDAO.listOfUsers = listOfUsers;
    }
}
