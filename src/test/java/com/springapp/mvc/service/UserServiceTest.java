package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.User;
import com.springapp.mvc.utils.UserUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    private UsersDAO usersDAO;

    @Mock
    private CredentialsDAO credentialsDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAddUser() {
        UserUtils userUtils = new UserUtils();
        User user = userUtils.createUser();
        usersDAO.addUser(user);
        Mockito.when(usersDAO.findUserById(user.getUserId())).thenReturn(user);
        User userFromList = userService.getUserById(user.getUserId());
        assertEquals(user, userFromList);
    }

    @Test(expected = NullPointerException.class)
    public void shouldDeleteUser() {
        UserUtils userUtils = new UserUtils();
        User user = userUtils.createUser();
        usersDAO.addUser(user);
        lenient().when(usersDAO.findUserById(user.getUserId())).thenReturn(user);
        usersDAO.deleteUsers(user.getUserId());
        Mockito.when(usersDAO.findUserById(user.getUserId())).thenThrow(new NullPointerException());
    }

    @Test
    public void shouldGetParsedDataByID() {
        User user = new UserUtils().createUser();
        usersDAO.addUser(user);
        when(usersDAO.findUserById(user.getUserId())).thenReturn(user);
        final User actualUser = userService.getUserById(user.getUserId());
        assertEquals(user, actualUser);
    }
}
