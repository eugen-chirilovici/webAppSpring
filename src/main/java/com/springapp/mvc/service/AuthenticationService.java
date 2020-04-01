package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.enums.RoleType;
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

    public RoleType getRoleTypeByCredId(long credentialId) {
        return credentialsDAO.getRoleTypeByCredentialsId(credentialId);
    }

    public boolean deleteCredentialsById(long userId) {
        return credentialsDAO.deleteCredentialsById(userId);
    }

    public CredentialsDAO getCredentialsDAO() {
        return credentialsDAO;
    }

    public void setCredentialsDAO(CredentialsDAO credentialsDAO) {
        this.credentialsDAO = credentialsDAO;
    }
}
