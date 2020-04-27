package com.springapp.mvc.service;

import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.DeleteUserDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
public class UserService {

    @Autowired
    private UsersDAO usersDAO;

    public List<User> getAllUsers() {
        return UsersDAO.getListOfUsers();
    }

    public User getUserById(Long userId) throws CustomUserException {
        try {
            return usersDAO.findUserById(userId);
        }
        catch (Exception e) {
            throw new CustomUserException("User was not found.", INTERNAL_SERVER_ERROR);
        }
    }

    public User getUserByCredentials(Credentials userCredentials) {
        List<User> userByCredentialsId = usersDAO.findUserByCredentialsId(userCredentials.getId());
        if (!userByCredentialsId.isEmpty() && userByCredentialsId.size() == 1) {
            return userByCredentialsId.get(0);
        }
        return null;
    }

    public void removeUserById(DeleteUserDTO deleteUserDTO) throws CustomUserException {
        try {
            usersDAO.deleteUser(getUserById(deleteUserDTO.getDeletedUserId()));
        }
        catch (Exception e){
            throw new CustomUserException("Internal error. User wasn't deleted", INTERNAL_SERVER_ERROR);
        }
    }

    public void removeUserById(Long id) throws CustomUserException {
        try {
            usersDAO.deleteUser(getUserById(id));
        }
        catch (Exception e){
            throw new CustomUserException("Internal error. User wasn't deleted", INTERNAL_SERVER_ERROR);
        }
    }

    public void addUser(UserDTO userDTO) throws CustomUserException {
        validateUser(userDTO);
        try {
            usersDAO.saveUser(userDTO);
        } catch (Exception e){
            throw new CustomUserException("Database error, user wasn't added.", INTERNAL_SERVER_ERROR);
        }
    }

    public void updateUser(UserDTO userDTO) throws CustomUserException {
        User toBeUpdated = getUserById(userDTO.getId());
        validateUser(userDTO);
        toBeUpdated.setFirstName(userDTO.getFirstName());
        toBeUpdated.setLastName(userDTO.getLastName());
        toBeUpdated.setDob(userDTO.getDob());
        try {
            usersDAO.saveUser(toBeUpdated);
        } catch (Exception e) {
            throw new CustomUserException("Error! User was not updated.", INTERNAL_SERVER_ERROR);
        }

    }

    private boolean validateUser(UserDTO userDTO) throws CustomUserException {
        try {
            if (validateNameAndSurname(userDTO.getFirstName(), userDTO.getLastName())){
                return true;
            }
            else {
                throw new CustomUserException("Fields are invalid", HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException nullptr) {
            throw new CustomUserException("Fill in the fields", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean userExists(User optionalUser) throws CustomUserException {
        if (optionalUser != null) {
            return true;
        }
        else return false;
        //throw new CustomUserException("User was not found", INTERNAL_SERVER_ERROR);
    }


    private boolean validateNameAndSurname(String firstName, String lastName) {
        return (!firstName.isEmpty() && !lastName.isEmpty() && !firstName.contains(" ") && !lastName.contains(" ")
                && firstName.length() >= 3 && lastName.length() >= 2 && !firstName.matches(".\\d.*")
                && !lastName.matches(".\\d.*"));
    }
}
