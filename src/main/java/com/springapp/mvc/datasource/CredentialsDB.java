package com.springapp.mvc.datasource;

import com.springapp.mvc.model.Credentials;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class CredentialsDB {
    private static Map<Credentials, Long> listOfCredentials = new HashMap<>();

    static {
        listOfCredentials.put(new Credentials("echirilovici", "2222"), 0L);
        listOfCredentials.put(new Credentials("cnicuta", "3333"), 1L);
        listOfCredentials.put(new Credentials("frosca", "4444"), 2L);
    }

    public void addCredential(Credentials credentials, Long userId) {
        listOfCredentials.put(new Credentials(credentials.getLogin(), credentials.getPassword()), userId);
    }

    public Long validateUser(Credentials credentials) {
        return listOfCredentials.get(credentials);
    }
}
