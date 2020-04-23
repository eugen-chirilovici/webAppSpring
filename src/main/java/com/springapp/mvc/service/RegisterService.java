package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private CredentialsDAO credentialsDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersDAO usersDAO;

    public void addRegisterUser(UserRegistDTO userRegistDTO) {
        Credentials credentials = new Credentials();
        credentials.setUsername(userRegistDTO.getUsername());
        credentials.setPassword(passwordEncoder.encode(userRegistDTO.getPassword()));

        Long credentialId = credentialsDAO.addCredential(credentials, RoleType.ROLE_USER);

        User user = User.builder()
                .firstName(userRegistDTO.getFirstName())
                .lastName(userRegistDTO.getLastName())
                .age(Integer.parseInt(userRegistDTO.getAge()))
                .hobby(userRegistDTO.getHobby())
                .credentialsId(credentialId)
                .build();
        usersDAO.addUser(user);
    }
}
