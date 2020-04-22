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
        listOfUsers.add(new User(id++, "Eugen", "Chirilovici", 24, "Sport", 0L));
        listOfUsers.add(new User(id++, "Ciprian", "Nicuta", 24, "Sport", 1L));
        listOfUsers.add(new User(id++, "Filip", "Rosca", 24, "Sport", 2L));
    }

    public Long addUser(User user) {
        long userId = id++;
        listOfUsers.add(new User(userId, user.getFirstName(), user.getLastName(), user.getAge(), user.getHobby(), user.getCredentialsId()));
        return userId;
    }

    public void deleteUser(User user){
        listOfUsers.remove(user);
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

    public User updateUser(Long id, UserDTO userDTO){
        for(User user:listOfUsers){
            if(user.getUserId() == id){
                if(userDTO.getFirstName() != null)
                    user.setFirstName(userDTO.getFirstName());
                if(userDTO.getLastName() != null)
                    user.setLastName(userDTO.getLastName());
                if(userDTO.getAge() != null){
                    user.setAge(Integer.parseInt(userDTO.getAge()));
                }
                if(userDTO.getHobby() != null){
                    user.setHobby(userDTO.getHobby());
                }
                return user;
            }
        }
        return null;
    }
}
