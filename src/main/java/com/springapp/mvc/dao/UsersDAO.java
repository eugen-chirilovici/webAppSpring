package com.springapp.mvc.dao;

import com.springapp.mvc.dto.DetUserDTO;
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
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 26, "Male",  0L));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 28, "Male",  1L));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 35, "Male", 2L));
    }

    public void save(DetUserDTO detUserDTO){
        listOfUsers.add(new User(detUserDTO.getFirstName(), detUserDTO.getLastName()));
    }

    public void save(User user){
        listOfUsers.add(new User(user.getFirstName(), user.getLastName()));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getAge(), user.getGender(), user.getCredentialsId()));
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

    public void deleteUser(User user){
        listOfUsers.remove(findUserById(user.getUserId()));
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
