package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static com.springapp.mvc.dao.UsersDAO.getListOfUsers;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UsersDAO.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UsersDAO usersDAO;

    @Mock
    private CredentialsDAO credentialsDAO;

    private Long id;

    private User user;

    @Before
    public void init(){
        id = 1l;
        user = new User("Iulian", "Cuciuc", id);
    }

    @Test
    public void testGetAllUsers(){
        List<User> userList = asList(user);

        mockStatic(UsersDAO.class);

        when(getListOfUsers()).thenReturn(userList);
        assertEquals(userList, userService.getAllUsers());

    }

    @Test
    public void testGetUserById(){
        when(usersDAO.findUserById(id)).thenReturn(user);

        assertEquals(user, userService.getUserById(id));
        assertNotNull(userService.getUserById(id));

        verify(usersDAO, times(2)).findUserById(id);
    }

    @Test
    public void testGetUserInformationById(){
        when(usersDAO.findUserById(id)).thenReturn(user);
        assertNotNull(userService.getUserInformationById(id));
    }

    @Test
    public void testGetUserByCredentials(){
        Credentials credentials = new Credentials(id, "iulian", "test", RoleType.ROLE_USER);
        List<User> users = asList(user);

        when(usersDAO.findUserByCredentialsId(id)).thenReturn(users);

        assertNotNull(userService.getUserByCredentials(credentials));
    }

    @Test
    public void failedTestGetUserByCredentials(){
        Credentials credentials = new Credentials(id, "iulian", "test", RoleType.ROLE_USER);
        List<User> users = new ArrayList<>();

        when(usersDAO.findUserByCredentialsId(id)).thenReturn(users);

        assertNull(userService.getUserByCredentials(credentials));
    }

    @Test
    public void testDeleteUserById(){
        Credentials credentials = new Credentials(id, "iulian", "test", RoleType.ROLE_USER);

        when(usersDAO.findUserById(id)).thenReturn(user);
        when(credentialsDAO.findCredentialsById(id)).thenReturn(credentials);

        assertEquals(true, userService.deleteUserById(id));

        verify(usersDAO, times(1)).findUserById(id);
        verify(usersDAO, times(1)).deleteUser(user);

        verify(credentialsDAO, times(1)).findCredentialsById(id);
        verify(credentialsDAO, times(1)).deleteCredentials(credentials);
    }

    @Test
    public void failedTestDeleteUserById(){
        Credentials credentials = null;
        user = null;

        when(usersDAO.findUserById(id)).thenReturn(user);
        when(credentialsDAO.findCredentialsById(id)).thenReturn(credentials);

        assertEquals(false, userService.deleteUserById(id));
    }

}
