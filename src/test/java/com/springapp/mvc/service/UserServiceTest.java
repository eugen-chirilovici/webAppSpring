package com.springapp.mvc.service;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.DeleteUserDto;
import com.springapp.mvc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static com.springapp.mvc.dao.UsersDAO.getListOfUsers;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

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
    public void testGetAllUsers(){
        User user = new User("Mihai", "Popescu", 1l);
        List<User> userList = asList(user);

        mockStatic(UsersDAO.class);

        when(getListOfUsers()).thenReturn(userList);
        assertEquals(userList, getListOfUsers());

    }

    @Test
    public void testGetUserById(){
        User user = new User("Mihai", "Popescu", 1l);

        when(usersDAO.findUserById(2L)).thenReturn(user);

        assertEquals(user, userService.getUserById(2l));
        assertNotNull(userService.getUserById(2l));

        verify(usersDAO, times(2)).findUserById(2l);
    }

    @Test
    public void deleteUserById(){
                  User user = new User("Mihai", "Popescu", 1l);
        DeleteUserDto deleteUserDto = new DeleteUserDto(1l);

        when(usersDAO.findUserById(1l)).thenReturn(user);

             userService.deleteUserById(deleteUserDto);
             verify(usersDAO, times(1)).findUserById(1l);
             verify(usersDAO, times(1)).deleteUser(user);


    }

}
