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
        if (userCredentials.size() == 1) {
            return userCredentials.get(0);
        }
        return null;
    }

    public CredentialsDAO getCredentialsDAO() {
        return credentialsDAO;
    }

    public void setCredentialsDAO(CredentialsDAO credentialsDAO) {
        this.credentialsDAO = credentialsDAO;
    }

    public boolean checkRole (long l) {
        return credentialsDAO.adminValidator(l);
    }

    public long IDlength() {
        return CredentialsDAO.getId();
    }
}
