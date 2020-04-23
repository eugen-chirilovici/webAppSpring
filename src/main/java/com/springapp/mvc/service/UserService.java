package com.springapp.mvc.service;

import com.springapp.mvc.ExceptionHandler.CustomUserServiceException;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.DetUserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
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

    public DetUserDTO getUserDetailsById(Long userId) {
        User user = usersDAO.findUserById(userId);
        DetUserDTO detUserDTO = new DetUserDTO();
        return detUserDTO;
    }

    public User getUserByCredentials(Credentials userCredentials) {
        List<User> userByCredentialsId = usersDAO.findUserByCredentialsId(userCredentials.getId());
        if (!userByCredentialsId.isEmpty() && userByCredentialsId.size() == 1) {
            return userByCredentialsId.get(0);
        }
        return null;
    }

    public void addUser(DetUserDTO detUserDTO) throws CustomUserServiceException {
        validateUser(detUserDTO);
        try {
            usersDAO.save(new User(detUserDTO.getFirstName(), detUserDTO.getLastName()));
        } catch (Exception e) {
            throw new CustomUserServiceException("Data Source issue, user could not be saved", INTERNAL_SERVER_ERROR);
        }
    }

    public void updateUser(DetUserDTO detUserDTO) throws CustomUserServiceException{
        User user = getUserById(detUserDTO.getId());
        user.setFirstName(detUserDTO.getFirstName());
        user.setLastName(detUserDTO.getLastName());

        try {
            usersDAO.save(user);
        }catch (Exception e){
            throw new CustomUserServiceException("User wasn't updated", INTERNAL_SERVER_ERROR);
        }
    }

    public void deleteUserById(Long id) throws CustomUserServiceException{
        try{
            usersDAO.deleteUser(getUserById(id));
        }catch (Exception e){
            throw new CustomUserServiceException("User was not deleted", INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateUser(DetUserDTO detUserDTO) throws CustomUserServiceException {
        try {
            if (validateName(detUserDTO.getFirstName())) {
                if (validateName(detUserDTO.getLastName())) {
                    return true;
                } else {
                    throw new CustomUserServiceException("Try not to set an invalid surname", BAD_REQUEST);
                }
            }
            throw new CustomUserServiceException("Try not to set an invalid name", BAD_REQUEST);
        } catch (NullPointerException npe) {
            throw new CustomUserServiceException("Try to avoid null values", BAD_REQUEST);
        }
    }


    private boolean validateName(String name) {
        return !name.isEmpty() && !name.contains(" ") && name.length() >= 1 && !name.matches(".*\\d.*");
    }


    private void validateAge(Integer age) throws CustomUserServiceException {
        if (age>=0 && age<120) {
            return;
        }
        throw new CustomUserServiceException("You are trying to set an invalid age", BAD_REQUEST);
    }
}
