package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceTest {

    @InjectMocks
    private RegisterService registerService;

    @Mock
    private CredentialsDAO credentialsDAO;

    @Mock
    private UsersDAO usersDAO;

    @Test
    public void testAddRegisterUser(){
        UserRegistDTO userRegistDTO = new UserRegistDTO();
        userRegistDTO.setAge("12");
        User user = new User(userRegistDTO.getFirstName(), userRegistDTO.getLastName(), userRegistDTO.getAge(), userRegistDTO.getHobby(), 1l);
        Credentials credentials = new Credentials();

        when(credentialsDAO.addCredential(credentials, RoleType.ROLE_USER)).thenReturn(1l);

        registerService.addRegisterUser(userRegistDTO);

        verify(credentialsDAO, times(1)).addCredential(credentials, RoleType.ROLE_USER);
    }

    @Test
    public void testFindIfLoginExist(){
        String login = "iulian";
        when(credentialsDAO.findIfLoginExist(login)).thenReturn(true);
        assertEquals(true, registerService.findIfLoginExist(login));
    }

}
