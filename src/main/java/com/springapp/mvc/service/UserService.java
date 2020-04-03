package com.springapp.mvc.service;

import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserMoreDetailsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.springapp.mvc.dto.utils.DtoConverter.convertUserToDto;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    public List<User> getAllUsers() {
        return UsersDAO.getListOfUsers();
    }

    public User getUserById(Long userId) {
        return usersDAO.findUserById(userId);
    }

    public User getUserByCredentials(Credentials userCredentials) {
        List<User> userByCredentialsId = usersDAO.findUserByCredentialsId(userCredentials.getId());
        if (!userByCredentialsId.isEmpty() && userByCredentialsId.size() == 1) {
            return userByCredentialsId.get(0);
        }
        return null;
    }


    public UserMoreDetailsDTO getUserInformationByIdDTO(Long userId) {
        User user = usersDAO.findUserById(userId);
        return convertUserToDto(user);
    }

    public List <User> deletedUserList(User user) {
        getAllUsers().remove(user);
        return getAllUsers();
    }
}
