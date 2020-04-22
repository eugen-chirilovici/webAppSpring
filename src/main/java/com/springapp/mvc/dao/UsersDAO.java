package com.springapp.mvc.dao;

import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersDAO {

    private static long id = 0L;
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L, "Something", "SomeType", 23));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L, "Dancing", "Rock", 435));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L, "Some hobby", "Something",34));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(), user.getHobby(),
                user.getMusicPreferences(), user.getAge()));
        return userId;
    }

    public void adduser(UserDTO userDTO) {
        listOfUsers.add(new User(id++, userDTO.getFirstName(), userDTO.getLastName(), userDTO.getHobby(),
                userDTO.getMusicPreferences(), userDTO.getAge()));
    }

    public void deleteUsers(long l) {
            listOfUsers.remove((int)l);
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
