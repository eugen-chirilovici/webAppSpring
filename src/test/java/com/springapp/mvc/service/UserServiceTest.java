package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.utils.CredentialsUtils;
import com.springapp.mvc.utils.UserUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UsersDAO.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UsersDAO usersDAO;

    @Mock
    private CredentialsDAO credentialsDAO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(usersDAO);
    }

    @Test
    public void getAllUsers() {

        final List <User> expectedUserList = UserUtils.createUserList();
        mockStatic(UsersDAO.class);
        when(usersDAO.getListOfUsers()).thenReturn(expectedUserList);

        final List<User> actualUserList = userService.getAllUsers();

        assertEquals(actualUserList,expectedUserList);

    }

    @Test
    public void getUserById() {
        final User expectedUser = UserUtils.createUser();
        when(usersDAO.findUserById(expectedUser.getUserId())).thenReturn(expectedUser);
        final User actualUser = userService.getUserById(expectedUser.getUserId());

        verify(usersDAO).findUserById(expectedUser.getUserId());
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getUserByCredentials() {
        final Credentials credentialsForExpectedUser = CredentialsUtils.createCredentialsForUserRole();
        final User expectedUser = UserUtils.createUser();
        final List <User> userList = Collections.singletonList(expectedUser);

        when(usersDAO.findUserByCredentialsId(credentialsForExpectedUser.getId())).thenReturn(userList);

        final User actualUser = userService.getUserByCredentials(credentialsForExpectedUser);

        verify(usersDAO).findUserByCredentialsId(expectedUser.getCredentialsId());
        assertEquals(expectedUser, actualUser);

    }


    @Test
    public void deletedUserList() {


    }
}