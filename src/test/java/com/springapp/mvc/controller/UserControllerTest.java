package com.springapp.mvc.controller;

import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Nested;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Optional;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

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
    @WithMockUser
    public void failedTestShowAllUsers() throws Exception{
        mockMvc.perform(get("/allusers"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @WithMockUser
    public void testAllData() throws Exception {
        mockMvc.perform(get("/welcome")).andExpect(status().is3xxRedirection());
        mockMvc.perform(get("/alldata")).andExpect(status().isOk());
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(get("/login").with(user("frosca").password("test").roles("USER")));
    }

//    @Test
//    @WithMockUser(roles = {"ADMIN"})
//    public void failedTestShowPesonalData() throws Exception{
//        mockMvc.perform(get("/personal"))
//                .andExpect(status().is4xxClientError());
//    }

}
