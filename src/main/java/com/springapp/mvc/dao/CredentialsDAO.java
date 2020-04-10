package com.springapp.mvc.dao;

import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.enums.RoleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CredentialsDAO {

    private static List<Credentials> listOfCredentials = new ArrayList<>();
    private static long id = 0L;

    static {
        listOfCredentials.add(new Credentials(id++, "echirilovici", "test", RoleType.ROLE_ADMIN));
        listOfCredentials.add(new Credentials(id++, "cnicuta", "test", RoleType.ROLE_USER));
        listOfCredentials.add(new Credentials(id++, "frosca", "test", RoleType.ROLE_USER));
    }

    public Long addCredential(Credentials credentials, RoleType roleType) {
        //long credentialsId = id++;
        listOfCredentials.add(new Credentials(credentials.getId(), credentials.getLogin(), credentials.getPassword(), roleType));
        return credentials.getId();
    }

    public List<Credentials> validateUser(CredentialsDTO credentials) {
        return listOfCredentials.stream()
                .filter(t -> t.getLogin().equals(credentials.getLogin()) &&
                        t.getPassword().equals(credentials.getPassword()))
                .collect(Collectors.toList());
    }

    public Credentials getCredentialsByCredentialsId(long credentialsId) {
        return listOfCredentials.stream()
                .filter(t -> t.getId() == credentialsId)
                .findFirst().orElse(null);
    }

    public boolean deleteCredentialsById(long userId){
        return listOfCredentials.removeIf(credentials -> credentials.getId() == userId);
    }
}
