package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserDTO;
import com.springapp.mvc.dto.UserRegistDTO;
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
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceTest {

    @InjectMocks
    private RegisterService registerService;

    @Mock
    private CredentialsDAO credentialsDAO;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UsersDAO usersDAO;

    Long id;

    UserRegistDTO userRegistDTO;

    User user;

    Credentials credentials;

    @Before
    public void setUp() {
        id = 1l;
        userRegistDTO = new UserRegistDTO();
        userRegistDTO.setAge("12");
        user = new User();
        credentials = new Credentials();
    }

    @After
    public void tearDown(){
        verifyNoMoreInteractions(credentialsDAO);
    }

    @Test
    public void testAddRegisterUser(){
        when(credentialsDAO.addCredential(credentials, RoleType.ROLE_USER)).thenReturn(id);
        registerService.addRegisterUser(userRegistDTO);
        verify(credentialsDAO).addCredential(credentials, RoleType.ROLE_USER);
    }

}
