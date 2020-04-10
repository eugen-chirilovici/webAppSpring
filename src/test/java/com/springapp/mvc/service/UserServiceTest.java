package com.springapp.mvc.service;

import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.util.CredentialsUtils;
import com.springapp.mvc.util.UserUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import java.util.Collections;
import java.util.List;


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

    @Test
    public void testUserService() {
        assertEquals("class com.springapp.mvc.service.UserService", this.userService.getClass().toString());
    }
    @Test
    public void testGetAllUsers(){
        mockStatic(UsersDAO.class);
        final List<User> expectedUsers = UserUtils.createListOfUsers();

        when(UsersDAO.getListOfUsers()).thenReturn(expectedUsers);
        assertEquals(expectedUsers, userService.getAllUsers());

    }

    @Test
    public void testGetUserById(){
        final User expectedUser = UserUtils.createUser();

        when(usersDAO.findUserById(expectedUser.getUserId())).thenReturn(expectedUser);

        final User actualUser = userService.getUserById(expectedUser.getUserId());

        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);

        verify(usersDAO, times(1));
    }

    @Test
    public void shouldGetUserByCredentials() {
        final User expectedUser = UserUtils.createUser();
        final List<User> userList = Collections.singletonList(expectedUser);
        final Credentials credentialsForUser = CredentialsUtils.createCredentialsForAdminRole();

        when(usersDAO.findUserByCredentialsId(expectedUser.getCredentialsId())).thenReturn(userList);

        final User actualUser = userService.getUserByCredentials(credentialsForUser);

        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);
        verify(usersDAO, times(1));
    }

    @Test
    public void deleteUserById(){
        User expectedUser = UserUtils.createUser();

        when(usersDAO.deleteUserById(expectedUser.getUserId())).thenReturn(true);

        assertTrue(userService.deleteUserById(expectedUser.getUserId()));

        verify(usersDAO, times(1));
    }

}
