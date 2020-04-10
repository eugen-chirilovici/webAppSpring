package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import com.springapp.mvc.util.UserUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsersDAOTest {
    @Test
    public void shouldGetListOfUsers() {
        List<User> expectedList = UserUtils.createListOfUsers();
        UsersDAO.setListOfUsers(expectedList);
        List<User> actualList = UsersDAO.getListOfUsers();
        for (int i = 0; i < actualList.size(); i++) {
            doAssertEquals(expectedList.get(i), actualList.get(i));
        }
        assertEquals(actualList.size(), expectedList.size());
    }

    @Test
    public void shouldCreateReadDeleteUser() {
        UsersDAO usersDAO = new UsersDAO();
        User expectedUser = UserUtils.createUser();

        //Create a new user
        Long expectedUserId = usersDAO.addUser(expectedUser);
        assertEquals(expectedUser.getUserId(), expectedUserId);

        //Read data about user
        User actualUser = usersDAO.findUserById(expectedUserId);
        assertNotNull(actualUser);

        //assertEquals(expectedUser, actualUser); why is not working?
        doAssertEquals(expectedUser, actualUser);

        //Delete user
        boolean response = usersDAO.deleteUserById(expectedUserId);
        assertTrue(response);
        assertNull(usersDAO.findUserById(expectedUser.getUserId()));
    }

    private void doAssertEquals(User expectedUser, User actualUser) {
        assertEquals(expectedUser.getUserId(), actualUser.getUserId());
        assertEquals(expectedUser.getFirstName(), actualUser.getFirstName());
        assertEquals(expectedUser.getLastName(), actualUser.getLastName());
        assertEquals(expectedUser.getCredentialsId(), actualUser.getCredentialsId());
        assertEquals(expectedUser.getBirthDate(), actualUser.getBirthDate());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

}
