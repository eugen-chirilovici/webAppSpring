package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.DeleteUserDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.dto.UserDataParser;
import com.springapp.mvc.exceptionHandler.CustomExceptionHandler;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

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
        if (userByCredentialsId.size() == 1) {
            return userByCredentialsId.get(0);
        }
        return null;
    }

    public void deleteUser(long l) {
        usersDAO.deleteUsers(l);
    }

    public void deleteUser(DeleteUserDTO deleteUserDTO) throws CustomExceptionHandler {
        try {
            usersDAO.deleteUsers(deleteUserDTO.getRequiredID_Delete());
        } catch (Exception e) {
            throw new CustomExceptionHandler("Deleting the user is impossible", INTERNAL_SERVER_ERROR);
        }
    }

    public UserDataParser getUserByParsedId(Long l) {
        User user = usersDAO.findUserById(l);
        UserDataParser userDataParser = new UserDataParser();
        userDataParser.parser(user);
        return userDataParser;
    }

    public void addUser(UserDTO userDTO) throws CustomExceptionHandler {
        try {
            usersDAO.adduser(userDTO);
        } catch (Exception e) {
            throw new CustomExceptionHandler("Something went wrong...", INTERNAL_SERVER_ERROR);
        }
    }

    public void updateUser(UserDTO userDTO) throws CustomExceptionHandler {
        User user = usersDAO.findUserById(userDTO.getId());
        try {
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setHobby(userDTO.getHobby());
            user.setMusicPreferences(userDTO.getMusicPreferences());;
            user.setAge(userDTO.getAge());
        } catch (NullPointerException e) {
            throw new NullPointerException("Some fields are null.");
        }
        try {
            usersDAO.addUser(user);
        } catch (Exception e) {
            throw new CustomExceptionHandler("Something went wrong...", INTERNAL_SERVER_ERROR);
        }
    }
}
