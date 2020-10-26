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
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 0L,52,false));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 1L,23,false));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 2L,35,true));
        listOfUsers.add(new User(id++, "Dmitri", "Sprinceac", 3L,25,false));
        listOfUsers.add(new User(id++, "Dmitri", "Admin", 4L,25,true));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getCredentialsId(),
                user.getAge(),user.getMarried()));
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


    public void removeUser(int id){

        listOfUsers.remove(id);
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
