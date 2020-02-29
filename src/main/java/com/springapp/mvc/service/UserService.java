package com.springapp.mvc.service;

import com.springapp.mvc.datasource.UsersDB;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersDB usersDB;

//    public List<User> getAllByGender(String genders){
//        return UsersDB
//                .getListOfUsers()
//                .stream()
//                .filter(n->n.getGenders().toString().equalsIgnoreCase(genders))
//                .collect(Collectors.toList());
//    }

    public List<User> getAllUsers() {
        return UsersDB.getListOfUsers();
    }

    public User getUserById(Long userId) {
        return usersDB.findUserById(userId);
    }
}
