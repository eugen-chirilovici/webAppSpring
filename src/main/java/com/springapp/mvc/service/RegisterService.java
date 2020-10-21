package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private CredentialsDAO credentialsDAO;

    @Autowired
    private UsersDAO usersDAO;

    public void addRegisterUser(UserRegistDTO userRegistDTO) {
        Credentials credentials = new Credentials();
        credentials.setLogin(userRegistDTO.getLogin());
        credentials.setPassword(userRegistDTO.getPassword());

        Long credentialId = credentialsDAO.addCredential(credentials, RoleType.ROLE_USER);

        User user = new User(userRegistDTO.getFirstName(), userRegistDTO.getLastName(), credentialId,userRegistDTO.getGender()
        ,userRegistDTO.getEmail());
        usersDAO.addUser(user);
    }
}
