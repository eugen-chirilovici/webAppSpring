package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserMoreDetailsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.springapp.mvc.dto.utils.DtoConverter.convertUserToDto;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private CredentialsDAO credentialsDAO;

    public List<User> getAllUsers() {
        return UsersDAO.getListOfUsers();
    }

    public User getUserById(Long userId) {
        return usersDAO.findUserById(userId);
    }


    public UserMoreDetailsDTO getUserInformationByIdDTO(String userName) {
        User user = getUserByUserName(userName);
        return convertUserToDto(user);
    }

    public List <User> deletedUserList(User user) {
        getAllUsers().remove(user);
        return getAllUsers();
    }

    public User getUserByUserName(String username) {
        Optional<Credentials> userByScreenName = credentialsDAO.findByUsername(username);
        return userByScreenName
                .map(credentials ->
                        usersDAO.findUserByCredentialsId(credentials.getId())
                                .orElse(null))
                .orElse(null);
    }
}
