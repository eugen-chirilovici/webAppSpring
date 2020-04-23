package com.spring.mvc;

import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static com.springapp.mvc.dao.UsersDAO.getListOfUsers;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(UsersDAO.class)
public class TestDAOMVC {

        @InjectMocks
        private UserService userService;

        @Mock
        private UsersDAO usersDAO;

        @Mock
        private CredentialsDAO credentialsDAO;

        private User user;
        @Before
        public void beforeFunction(){
            user = new User(3L,"Anton", "Pavlov", 3L);

        }

        @Test
        public void shouldGetAllUsers(){
            List<User> userList = new ArrayList<>();
            userList.add(new User(0L, "Eugen", "Chirilovici", 26, "Male",  0L));
            userList.add(new User(1L, "Ciprian", "Nicuta", 28, "Male",  1L));
            userList.add(new User(2L, "Filip", "Rosca", 35, "Male", 2L));

            when(usersDAO.findUserById(0L)).thenReturn(userList.get(0));
            when(usersDAO.findUserById(1L)).thenReturn(userList.get(1));
            when(usersDAO.findUserById(2L)).thenReturn(userList.get(2));

            assertEquals(userList.get(0), usersDAO.findUserById(0L));
            assertEquals(userList.get(1), usersDAO.findUserById(1L));
            assertEquals(userList.get(2), usersDAO.findUserById(2L));


        }


        @Test
        public void shouldGetUserById() {

            when(usersDAO.findUserById(3L)).thenReturn(user);
            System.out.println(user.getFirstName() + user.getLastName());
            assertEquals(user, usersDAO.findUserById(3L));
            assertNotNull(userService.getUserById(3L));

        }
}
