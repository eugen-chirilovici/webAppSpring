package com.springapp.mvc.dao;

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
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L, "eugen.chirilovici@gmail.com", "25.09.1996" ));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L,"ciprina.nicuta@gmail.com", "07.04.1995"));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L, "filip.rosca@gmail.com", "02.02.1989"));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(), user.getEmail(), user.getBirthdate()));
        return userId;
    }

    public void deleteUser(int id) {
        if (listOfUsers.stream().anyMatch(t -> t.getUserId() == id))
            listOfUsers.remove(listOfUsers.stream().filter(t -> t.getUserId() == id).findAny().get());
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
