package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.utils.CredentialsUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {

    @InjectMocks
    private AuthenticationService authenticationService;

    @Mock
    private CredentialsDAO credentialsDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldValidateAdminUserWithAdminValidator() {
        Credentials credentials = new CredentialsUtils().createCredentialsForAdminRole();
        credentialsDAO.addCredential(credentials, RoleType.ROLE_ADMIN);
        lenient().when(credentialsDAO.adminValidator(credentials.getId())).thenReturn(credentialsDAO.flag);
    }
}
