package com.springapp.mvc.controller;


import com.springapp.mvc.dao.UsersDAO;
import com.springapp.mvc.dto.UserMoreDetailsDTO;
import org.springframework.security.core.userdetails.User;
import com.springapp.mvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Mock
    private UserMoreDetailsDTO userMoreDetailsDTO;

    @Mock
    private UserService userService;

    @Mock
    private User loggedUser;


    @Mock
    private UsersDAO usersDAO;


//    @Before
//    public void setUp() {
//        InternalResourceViewResolver viewResolver;
//        viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/jsp/pages/");
//        viewResolver.setSuffix(".jsp");
//
//        this.mockMvc = MockMvcBuilders
//                        .standaloneSetup(userController)
//                        .setViewResolvers(viewResolver)
//                        .build();
//    }

    @Before
    public void contextLoads() {
        assertThat(userController).isNotNull();

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser()
    public void shouldPrintWelcome() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("message"));
    }

    @Test
    @WithMockUser()
    public void shouldGetError() throws Exception{
        mockMvc.perform(get("/error"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attributeExists("errorMessage"));
    }

    @Test
    @WithMockUser()
    public void shouldGetPersonalCab() throws Exception{
        mockMvc.perform(get("/personal"))
                .andExpect(status().isOk())
                .andExpect(view().name("personalCab"))
                .andExpect(model().attributeExists("users", "title", "message"));
    }


    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void shouldGetAllUsers() throws Exception{
        mockMvc.perform(get("/allusers"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attributeExists("users", "title", "message"));
    }

    @Test
    @WithMockUser()
    public void shouldGetMoreDetails() throws Exception{
        mockMvc.perform(get("/moredetails"))
                .andExpect(status().isOk())
                .andExpect(view().name("moreDetails"))
                .andExpect(model().attributeExists("usersdetails", "message"));
    }

    @Test
    @WithMockUser()
    public void shouldRedirectToAllUsersAfterDelete() throws Exception{
        mockMvc.perform(post("/deleteUser/{id}",1000))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/allusers"))
                .andExpect(model().attributeExists("users"));

    }

}