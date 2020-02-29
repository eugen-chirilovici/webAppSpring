package com.springapp.mvc.service;

import com.springapp.mvc.datasource.CredentialsDB;
import com.springapp.mvc.datasource.UsersDB;
import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private CredentialsDB credentialsDB;

    @Autowired
    private UsersDB usersDB;

    public void addRegisterUser(UserRegistDTO userRegistDTO) {
        User user = new User(userRegistDTO.getFirstName(), userRegistDTO.getLastName());
        Long userId = usersDB.addUser(user);
        Credentials credentials = new Credentials(userRegistDTO.getLogin(), userRegistDTO.getPassword());
        credentialsDB.addCredential(credentials, userId);
    }
}
