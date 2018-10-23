package com.springapp.mvc.service;

import com.springapp.mvc.datasource.UsersDatabaseImitation;
import com.springapp.mvc.model.Genders;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UsersDatabaseImitation usersDatabaseImitation;

    public boolean checkUser(User user) {
        for(User u: UsersDatabaseImitation.getListOfUsers()) {
            if (user.equals(u)) return true;
        }
        return false;
    }

    public List<User> getAllByGender(String genders){
        return UsersDatabaseImitation
                .getListOfUsers()
                .stream()
                .filter(n->n.getGenders().toString().equalsIgnoreCase(genders))
                .collect(Collectors.toList());
    }

    public List<User> getAllUsers() {
        return UsersDatabaseImitation.getListOfUsers();
    }
}
