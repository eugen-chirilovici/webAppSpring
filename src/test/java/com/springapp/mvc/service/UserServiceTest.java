package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.DeleteUserDTO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UsersDAO mockUsersDAO;
    @Mock
    private CredentialsDAO mockCredentialsDAO;

    @InjectMocks
    private UserService userServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        // Setup

        // Run the test
        final List<User> result = userServiceUnderTest.getAllUsers();

    }

    @Test
    public void testGetUserById() {
        // Setup

        // Configure UsersDAO.findUserById(...).
        final User user = new User(0L, "firstName", "lastName", 0L, "dob");
        when(mockUsersDAO.findUserById(0L)).thenReturn(user);

        // Run the test
        final User result = userServiceUnderTest.getUserById(0L);

    }

    @Test
    public void testGetUserByInfoId() {
        // Setup

        // Configure UsersDAO.findUserById(...).
        final User user = new User(0L, "firstName", "lastName", 0L, "dob");
        when(mockUsersDAO.findUserById(0L)).thenReturn(user);

        // Run the test
        final UserDTO result = userServiceUnderTest.getUserByInfoId(0L);

    }

    @Test
    public void testGetUserByCredentials() {
        // Setup
        final Credentials userCredentials = new Credentials(0L, "login", "password", RoleType.ROLE_ADMIN);

        // Configure UsersDAO.findUserByCredentialsId(...).
        final Optional<User> optionalUser = Optional.of(new User(0L, "firstName", "lastName", 0L, "dob"));
        when(mockUsersDAO.findUserByCredentialsId(0L)).thenReturn(optionalUser);

        // Run the test
        final User result = userServiceUnderTest.getUserByCredentials(userCredentials);

    }

    @Test
    public void testGetUserByUsername() {

        // Configure CredentialsDAO.findUserByUsername(...).
        final Optional<Credentials> credentials = Optional.of(new Credentials(0L, "login", "password", RoleType.ROLE_ADMIN));
        when(mockCredentialsDAO.findUserByUsername("login")).thenReturn(credentials);

        // Configure UsersDAO.findUserByCredentialsId(...).
        final Optional<User> optionalUser = Optional.of(new User(0L, "firstName", "lastName", 0L, "dob"));
        when(mockUsersDAO.findUserByCredentialsId(0L)).thenReturn(optionalUser);

        // Run the test
        final User result = userServiceUnderTest.getUserByUsername("username");

    }

    @Test
    public void testRemoveUserById() {
        // Setup
        final DeleteUserDTO deleteUserDTO = new DeleteUserDTO(0L);

        // Configure UsersDAO.findUserById(...).
        final User user = new User(0L, "firstName", "lastName", 0L, "dob");
        when(mockUsersDAO.findUserById(0L)).thenReturn(user);

        // Run the test
        userServiceUnderTest.removeUserById(deleteUserDTO);

        // Verify the results
        verify(mockUsersDAO).deleteUser(any(User.class));
    }

    @Test
    public void testRemoveUserById1() {
        // Setup

        // Configure UsersDAO.findUserById(...).
        final User user = new User(0L, "firstName", "lastName", 0L, "dob");
        when(mockUsersDAO.findUserById(0L)).thenReturn(user);

        // Configure CredentialsDAO.findCredentialsById(...).
        final Credentials credentials = new Credentials(0L, "login", "password", RoleType.ROLE_ADMIN);
        when(mockCredentialsDAO.findCredentialsById(0L)).thenReturn(credentials);

        // Run the test
        final boolean result = userServiceUnderTest.removeUserById(0L);

        // Verify the results
        assertTrue(result);
        verify(mockUsersDAO).deleteUser(any(User.class));
        verify(mockCredentialsDAO).deleteCredentials(new Credentials(0L, "login", "password", RoleType.ROLE_ADMIN));
    }
}
