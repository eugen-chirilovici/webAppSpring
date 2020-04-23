package com.springapp.mvc.controller;

import com.springapp.mvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private User user;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();

    }

    @Test
    public void testPrintWelcome() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"));
    }

    @Test
    public void testPrintLogin() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser()
    public void testRedirectToPersonalCabWhenRoleIsUser() throws Exception {
        mockMvc.perform(get("/welcome"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/personal"));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testRedirectToPersonalCabWhenRoleIsAdmin() throws Exception {
        mockMvc.perform(get("/welcome"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/allusers"));
    }

    @Test
    public void testErrorConnection() throws Exception{
        mockMvc.perform(get("/error"))
                .andExpect(view().name("error"))
                .andExpect(model().attributeExists("errorMessage"));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testShowAllUsers() throws Exception{
        mockMvc.perform(get("/allusers"))
                .andExpect(view().name("welcome"));
    }

    @Test
    @WithMockUser()
    public void failedTestShowAllUsers() throws Exception{
        mockMvc.perform(get("/allusers"))
                .andExpect(status().is4xxClientError());
    }

}
