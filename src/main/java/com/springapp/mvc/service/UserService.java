package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.dto.UserDetailsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private CredentialsDAO credentialsDAO;

    public List<UserDTO> getAllUsers() {
        return UsersDAO.getListOfUsers().stream()
                       .map(Converter.convertFromUserToUserDTO)
                       .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long userId) {
        return Converter.convertFromUserToUserDTO.apply(usersDAO.findUserById(userId));
    }

    public User getUserByCredentials(Credentials userCredentials) {
        List<User> userByCredentialsId = usersDAO.findUserByCredentialsId(userCredentials.getId());
        if (!userByCredentialsId.isEmpty() && userByCredentialsId.size() == 1) {
            return userByCredentialsId.get(0);
        }
        return null;
    }

    public RoleType getRegisterUserRole(User user) {

        if(user.getUserId() != null) {
            return credentialsDAO.findById(user.getCredentialsId()).getRole();
        } else {
            return null;
        }
    }

    public UserDetailsDTO getAllDetailsFromUser(User user) {

        UserDetailsDTO userDetailsDTO = usersDAO.getAllDetailsFromUserClass(user);
        userDetailsDTO.setLogin(credentialsDAO.findById(user.getCredentialsId()).getLogin());
        userDetailsDTO.setPassword(credentialsDAO.findById(user.getCredentialsId()).getPassword());
        userDetailsDTO.setRole(String.valueOf(credentialsDAO.findById(user.getCredentialsId()).getRole()));

        return userDetailsDTO;
    }
}
