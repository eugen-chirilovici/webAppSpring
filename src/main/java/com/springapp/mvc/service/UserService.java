package com.springapp.mvc.service;

import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    public List<User> getAllUsers() {
        return UsersDAO.getListOfUsers();
    }

    public User getUserById(Long userId) {
        return usersDAO.findUserById(userId);
    }

    public UserDTO getUserInformationById(Long userId) {
        User user = usersDAO.findUserById(userId);
        UserDTO userDTO = new UserDTO();
        userDTO.setUser(user);
        return userDTO;
    }

    public User getUserByCredentials(Credentials userCredentials) {
        List<User> userByCredentialsId = usersDAO.findUserByCredentialsId(userCredentials.getId());
        if (!userByCredentialsId.isEmpty() && userByCredentialsId.size() == 1) {
            return userByCredentialsId.get(0);
        }
        return null;
    }
}
