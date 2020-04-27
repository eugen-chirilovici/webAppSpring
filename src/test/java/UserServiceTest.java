
import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import com.springapp.mvc.utils.UserUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
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

    private List<User> userList;

    private Credentials credentials;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = new UserUtils().createUser();
        userList = new UserUtils().createListOfUsers();
        credentials = new UserUtils().createCredentials();
    }

    @After
    public void teardown(){
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
        assertNotNull(userService.getUserByInfoId(id));
        verify(usersDAO).findUserById(id);
    }


    @Test
    public void getUserByCredentials(){
        when(usersDAO.findUserByCredentialsId(id)).thenReturn(Optional.of(user));
        assertNotNull(userService.getUserByCredentials(credentials));
        verify(usersDAO).findUserByCredentialsId(id);
    }

    @Test
    public void negativeScenarioGetUserByCredentials(){
        when(usersDAO.findUserByCredentialsId(id)).thenReturn(Optional.of(user));
        assertNotNull(userService.getUserByCredentials(credentials).getUserId());
        verify(usersDAO).findUserByCredentialsId(id);
    }

    @Test
    public void deleteUserById(){

        when(usersDAO.findUserById(id)).thenReturn(user);
        when(credentialsDAO.findCredentialsById(id)).thenReturn(credentials);

        assertTrue(userService.removeUserById(id));

        verify(usersDAO).findUserById(id);
        verify(usersDAO).deleteUser(user);

        verify(credentialsDAO).findCredentialsById(id);
        verify(credentialsDAO).deleteCredentials(credentials);
    }

    @Test
    public void negativeScenarioDeleteUserById(){
        when(usersDAO.findUserById(id)).thenReturn(null);
        when(credentialsDAO.findCredentialsById(id)).thenReturn(null);
        assertFalse(userService.removeUserById(id));
        verify(usersDAO).findUserById(id);
    }
}