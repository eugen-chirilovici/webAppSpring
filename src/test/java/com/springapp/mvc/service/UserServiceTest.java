package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UsersDAO usersDAO;

    @Mock
    private CredentialsDAO credentialsDAO;

    private Long id;

    private User user;

    private Credentials credentials;

    @Before
    public void setUp(){
        id = 1l;
        user = new User();
        credentials = new Credentials(id, "iulian", "test", RoleType.ROLE_USER);
    }

    @After
    public void tearDown(){
        verifyNoMoreInteractions(usersDAO);
    }

    @Test
    public void testGetUserById(){
        when(usersDAO.findUserById(id)).thenReturn(user);
        assertEquals(user, userService.getUserById(id));
        verify(usersDAO).findUserById(id);
    }

    @Test
    public void getUserInformationById(){
        when(usersDAO.findUserById(id)).thenReturn(user);
        assertNotNull(userService.getUserInformationById(id));
        verify(usersDAO).findUserById(id);
    }

    @Test
    public void testGetUserByCredentials(){
        when(usersDAO.findUserByCredentialsId(id)).thenReturn(Optional.of(user));
        assertNotNull(userService.getUserByCredentials(credentials));
        verify(usersDAO).findUserByCredentialsId(id);
    }

    @Test
    public void failedTestGetUserByCredentials(){
        when(usersDAO.findUserByCredentialsId(id)).thenReturn(Optional.of(user));
        assertNull(userService.getUserByCredentials(credentials).getUserId());
        verify(usersDAO).findUserByCredentialsId(id);
    }

    @Test
    public void testDeleteUserById(){
        when(usersDAO.findUserById(id)).thenReturn(user);
        when(credentialsDAO.findCredentialsById(id)).thenReturn(credentials);

        assertTrue(userService.deleteUserById(id));

        verify(usersDAO).findUserById(id);
        verify(usersDAO).deleteUser(user);

        verify(credentialsDAO).findCredentialsById(id);
        verify(credentialsDAO).deleteCredentials(credentials);
    }

    @Test
    public void failedTestDeleteUserById(){
        when(usersDAO.findUserById(id)).thenReturn(null);
        when(credentialsDAO.findCredentialsById(id)).thenReturn(null);
        assertFalse(userService.deleteUserById(id));
        verify(usersDAO).findUserById(id);
    }

}
