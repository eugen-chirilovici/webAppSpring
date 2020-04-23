package com.springapp.mvc.dao;

import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CredentialsDAO {

    private static List<Credentials> listOfCredentials = new ArrayList<>();
    private static long id = 0L;

    static {
        listOfCredentials.add(new Credentials(id++,
                "echirilovici",
                "$2a$10$m1sRJuy0ZvX69ey/7Xd2zuWAG7ddouWqC..ImkHawJTrm8QiwSSA.",
                RoleType.ROLE_ADMIN));
        listOfCredentials.add(new Credentials(id++,
                "cnicuta",
                "$2a$10$m1sRJuy0ZvX69ey/7Xd2zuWAG7ddouWqC..ImkHawJTrm8QiwSSA.",
                RoleType.ROLE_USER));
        listOfCredentials.add(new Credentials(id++,
                "frosca",
                "$2a$10$m1sRJuy0ZvX69ey/7Xd2zuWAG7ddouWqC..ImkHawJTrm8QiwSSA.",
                RoleType.ROLE_USER));
    }

    public Credentials findCredentialsById(Long userId) {
        for (Credentials credentials : listOfCredentials) {
            if (credentials.getId() == userId) {
                return credentials;
            }
        }
        return null;
    }

    public void deleteCredentials(Credentials credentials){
        listOfCredentials.remove(credentials);
    }

    public Long addCredential(Credentials credentials, RoleType roleType) {
        long credentialsId = id++;
        listOfCredentials.add(new Credentials(credentialsId, credentials.getUsername(), credentials.getPassword(), roleType));
        return credentialsId;
    }

    public Optional<Credentials> validateUser(CredentialsDTO credentials) {
        return listOfCredentials.stream()
                .filter(t -> t.getUsername().equals(credentials.getUsername()) &&
                        t.getPassword().equals(credentials.getPassword()))
                .findAny();
    }

    public Optional<Credentials> findByUsername(String login) {
        return listOfCredentials.stream()
                .filter(t -> t.getUsername().equals(login))
                .findAny();
    }

}
