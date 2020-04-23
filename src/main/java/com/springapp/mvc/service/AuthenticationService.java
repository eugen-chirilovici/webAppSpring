package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private CredentialsDAO credentialsDAO;

    public Credentials confirmAuthentication(CredentialsDTO credentials) {
        Optional<Credentials> credentialsOfUser = credentialsDAO.validateUser(credentials);
        return credentialsOfUser.orElse(null);
    }

    public CredentialsDAO getCredentialsDAO() {
        return credentialsDAO;
    }

    public void setCredentialsDAO(CredentialsDAO credentialsDAO) {
        this.credentialsDAO = credentialsDAO;
    }
}
