package app.mvc;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.DeleteUserDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;
import java.util.Optional;

import static com.springapp.mvc.dao.UsersDAO.getListOfUsers;
//import static com.sun.javaws.JnlpxArgs.verify;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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


    @Test
    public void getAllUserTest() {
        User user = new User("Eugen", "Chirilovici", 0L,"15 sept 1997");

        List<User> userList = asList(user);
        mockStatic(UsersDAO.class);

        when(getListOfUsers()).thenReturn(userList);
        assertEquals(userList, getListOfUsers());
    }

    @Test
    public void getUserByIdTest() {
        final User expectedUser = new User("Eugen", "Chirilovici", 0L,"15 sept 1997");

        when(usersDAO.findUserById(expectedUser.getUserId())).thenReturn(expectedUser);

        final User actualUser = userService.getUserById(expectedUser.getUserId());
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void getUserByCredentialsTest() {

        final Credentials credentialsForExpectedUser = new Credentials(0L, "echirilovici", "test", RoleType.ROLE_ADMIN);
        User user = new User("Eugen", "Chirilovici", 0L,"15 sept 1997");
        final List<User> expectedUser = asList(user);

        when(usersDAO.findUserByCredentialsId(credentialsForExpectedUser.getId())).thenReturn((expectedUser));

        final User actualUser = userService.getUserByCredentials(credentialsForExpectedUser);

        assertEquals(expectedUser.get(0), actualUser);
    }

    @Test
    public void deleteUserTest() {
        User user = new User("Eugen", "Chirilovici", 0L,"15 sept 1997");
        List<User> userL = asList(user);
        DeleteUserDTO deleteUserDTO = new DeleteUserDTO(0L);

        when(usersDAO.findUserById(0L)).thenReturn(user);

        userService.removeUserById(deleteUserDTO);

        verify(usersDAO, times(1)).findUserById(0L);
        verify(usersDAO, times(1)).deleteUser(user);
    }


}
