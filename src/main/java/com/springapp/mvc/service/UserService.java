package com.springapp.mvc.service;

import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserRestDTO;
import com.springapp.mvc.dto.UserMoreDetailsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.springapp.mvc.dto.utils.DtoConverter.convertUserToDto;

@Data
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

    public List <User> deletedUserList(User user) {
        getAllUsers().remove(user);
        return getAllUsers();
    }

    public User getUserByCredentials(Credentials userCredentials) {
        List<User> userByCredentialsId = usersDAO.findUserByCredentialsId(userCredentials.getId());
        if (userByCredentialsId.size() == 1) {
            return userByCredentialsId.get(0);
        }
        return null;
    }

    public void createUser(UserRestDTO userRestDTO) {
        User user = new User(userRestDTO.getFirstName(), userRestDTO.getLastName());
        usersDAO.addUser(user);
    }

    public UserMoreDetailsDTO readUserById(Long userId) {
        User user = usersDAO.findUserById(userId);
        return convertUserToDto(user);
    }

    public void updateUser(UserRestDTO userRestDTO, Long id) {
        User actualUser = usersDAO.findUserById(id);
        actualUser.setFirstName(userRestDTO.getFirstName());
        actualUser.setLastName(userRestDTO.getLastName());
        actualUser.setEmail(userRestDTO.getEmail());
    }

    public void deleteUser(User user) {
        getAllUsers().remove(user);
    }
}
