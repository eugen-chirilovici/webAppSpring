package com.springapp.mvc.service;

import com.springapp.mvc.appConfiguration.Validation;
import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.DeleteUserDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private CredentialsDAO credentialsDAO;

    public List<User> getAllUsers() {
        return UsersDAO.getListOfUsers();
    }

    public User getUserById(Long userId) {
        return usersDAO.findUserById(userId);
    }

    public UserDTO getUserByInfoId(Long id) {
        User user = usersDAO.findUserById(id);
        return new UserDTO();
    }

    public User getUserByCredentials(Credentials userCredentials) {
        return usersDAO
                .findUserByCredentialsId(userCredentials.getId())
                .orElse(null);
    }

    public User getUserByUsername(String username) {
        Optional<Credentials> userByUsername = credentialsDAO.findUserByUsername(username);
        return userByUsername.map(credentials -> usersDAO.findUserByCredentialsId(credentials.getId()))
                .orElse(null)
                .orElse(null);
    }

    public void removeUserById(DeleteUserDTO deleteUserDTO) {
        usersDAO.deleteUser(getUserById(deleteUserDTO.getDeletedUserId()));
    }

    public boolean removeUserById(Long id) {
        User user = this.getUserById(id);
        Credentials credentials = credentialsDAO.findCredentialsById(id);
        if (Validation.validUser(user) && !Validation.incorrectCredentials(credentials)) {
            usersDAO.deleteUser(user);
            credentialsDAO.deleteCredentials(credentials);
            return true;
        }
        return false;
    }

}
