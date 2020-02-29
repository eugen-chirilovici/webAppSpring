package com.springapp.mvc.service;

import com.springapp.mvc.datasource.CredentialsDB;
import com.springapp.mvc.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private CredentialsDB credentialsDB;

    public Long confirmAuthentication(Credentials credentials) {
        return credentialsDB.validateUser(credentials);
    }

    public CredentialsDB getCredentialsDB() {
        return credentialsDB;
    }

    public void setCredentialsDB(CredentialsDB credentialsDB) {
        this.credentialsDB = credentialsDB;
    }
}
