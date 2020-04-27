package com.springapp.mvc.dao;

import com.springapp.mvc.dto.DeleteUserDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class UsersDAO {

    private static long id = 0L;
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L,"15 sept 1997"));
        listOfUsers.add(new User(id++, "Nichita", "Ganja", 1L, "26 oct 1998"));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 2L, "1 jan 1990"));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 3L, "31 dec 1989"));
    }

    public void saveUser(UserDTO userDTO) {
        listOfUsers.add(new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getDob()));
    }
    public void saveUser(User user) {
        listOfUsers.add(new User(user.getUserId(), user.getFirstName(), user.getLastName(), user.getDob()));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(), user.getDob()));
        return userId;
    }

    public void deleteUser(User user) {
        listOfUsers.remove(findUserById(user.getUserId()));
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
