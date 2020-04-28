package com.springapp.mvc.service;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UsersDAO usersDAO;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(usersDAO);
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
        final Optional<User> expectedUser = Optional.ofNullable(UserUtils.createUser());

        when(usersDAO.findUserByCredentialsId(credentialsForExpectedUser.getId())).thenReturn((expectedUser));

        final Optional<User> actualUser = usersDAO.findUserByCredentialsId(credentialsForExpectedUser.getId());

        verify(usersDAO).findUserByCredentialsId(expectedUser.get().getCredentialsId());
        assertEquals(expectedUser, actualUser);

    }

}