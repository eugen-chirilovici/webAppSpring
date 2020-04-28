package app.mvc.service;

import app.mvc.dao.CredentialsDAO;
import app.mvc.dao.UsersDAO;
import app.mvc.dto.UserRegistDTO;
import app.mvc.model.Credentials;
import app.mvc.model.User;
import app.mvc.model.enums.RoleType;
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

    public boolean loginValidator(String input) {
        return credentialsDAO.validator(input);
    }

    public void addRegisterUser(UserRegistDTO userRegistDTO) {
        Credentials credentials = new Credentials();
        credentials.setUsername(userRegistDTO.getUsername());
        credentials.setPassword(passwordEncoder.encode(userRegistDTO.getPassword()));

        Long credentialId = credentialsDAO.addCredential(credentials, RoleType.ROLE_USER);

        User user = User.builder()
                .firstName(userRegistDTO.getFirstName())
                .lastName(userRegistDTO.getLastName())
                .credentialsId(credentialId)
                .hobby(userRegistDTO.getHobby())
                .musicPreferences(userRegistDTO.getMusicPreferences())
                .age(userRegistDTO.getAge())
                .build();
        usersDAO.addUser(user);
    }

}
