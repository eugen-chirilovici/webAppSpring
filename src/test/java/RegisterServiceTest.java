import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserRegistDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.service.RegisterService;
import com.springapp.mvc.utils.UserUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = new UserUtils().createUser();
        credentials = new UserUtils().createCredentials();
        userRegistDTO = new UserUtils().createRegistDTO();
    }

    @After
    public void tearDown(){
        verifyNoMoreInteractions(credentialsDAO);
    }

    @Test
    public void testAddRegisterUser(){
        when(credentialsDAO.addCredential(credentials, RoleType.ROLE_USER)).thenReturn(id);
        registerService.addRegisterUser(userRegistDTO);
        verify(credentialsDAO).addCredential(credentials,RoleType.ROLE_USER);

    }
}
