package com.springapp.mvc.dao;

import com.springapp.mvc.dto.UserDetailsDTO;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersDAO {

    private static long id = 0L;
    private static List<User> listOfUsers = new ArrayList<>();

    static {
        listOfUsers.add(new User(id++, "Ion", "Popovici", 0L, 32, 0, "Medic"));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L, 28, 2, "Policeman"));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L, 45, 1, "Mayor"));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(),
                user.getAge(), user.getChildren(), user.getJob()));
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

    public void deleteUserById (long userId) {

        listOfUsers.remove((int)userId);
    }
}
