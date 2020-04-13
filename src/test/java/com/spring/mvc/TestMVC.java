package com.spring.mvc;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static com.springapp.mvc.dao.UsersDAO.getListOfUsers;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UsersDAO.class)
public class TestMVC {


        @InjectMocks
        private UserService userService;

        @Mock
        private UsersDAO usersDAO;

        @Mock
        private CredentialsDAO credentialsDAO;

        @Test
        public void shouldGetAllUsers(){
            User user = new User(1L, "Victor", "Suluceanu", 1l);
            List<User> userList = asList(user);

            mockStatic(UsersDAO.class);

            when(getListOfUsers()).thenReturn(userList);
            assertEquals(userList, getListOfUsers());

        }

        @Test
        public void shouldGetUserById() {
            User user = new User(3L,"Anton", "Pavlov", 3L);

            when(usersDAO.findUserById(1L)).thenReturn(user);

            assertEquals(user, userService.getUserById(2L));
            assertNotNull(userService.getUserById(3L));

            verify(usersDAO, times(2)).findUserById(2L);
        }
}
