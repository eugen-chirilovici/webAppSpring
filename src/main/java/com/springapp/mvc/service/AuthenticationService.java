package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private CredentialsDAO credentialsDAO;

    public Credentials confirmAuthentication(CredentialsDTO credentials) {
        List<Credentials> userCredentials = credentialsDAO.validateUser(credentials);
        if (!userCredentials.isEmpty() && userCredentials.size() == 1) {
            return userCredentials.get(0);
        }
        return null;
    }

    public Credentials getCredentials(long id) {
        int newID=(int)id;
        return credentialsDAO.getCredentialsByID(newID);
    }

    public void setCredentialsDAO(CredentialsDAO credentialsDAO) {
        this.credentialsDAO = credentialsDAO;
    }
}
