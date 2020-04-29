package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RegisterServiceTest {

    @Mock
    private CredentialsDAO mockCredentialsDAO;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private UsersDAO mockUsersDAO;

    @InjectMocks
    private RegisterService registerServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testAddRegisterUser() {
        // Setup
        final UserRegistDTO userRegistDTO = UserRegistDTO.builder().build();
        when(mockPasswordEncoder.encode("charSequence")).thenReturn("result");
        when(mockCredentialsDAO.addCredential(new Credentials(0L, "login", "password", RoleType.ROLE_ADMIN), RoleType.ROLE_ADMIN)).thenReturn(0L);
        when(mockUsersDAO.addUser(any(User.class))).thenReturn(0L);

        // Run the test
        registerServiceUnderTest.addRegisterUser(userRegistDTO);


    }

    @Test
    public void testValidateExistingLogin() {
        // Setup
        final UserRegistDTO userRegistDTO = UserRegistDTO.builder().build();
        when(mockCredentialsDAO.doesUserExist("login")).thenReturn(false);

        // Run the test
        final boolean result = registerServiceUnderTest.validateExistingLogin(userRegistDTO);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testGetUserByLogin() {
        // Setup
        when(mockCredentialsDAO.findUserByLogin("login")).thenReturn("result");

        // Run the test
        final String result = registerServiceUnderTest.getUserByLogin("login");

        // Verify the results
        assertEquals("result", result);
    }
}
