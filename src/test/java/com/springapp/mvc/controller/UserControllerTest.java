package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class UserControllerTest {
    @InjectMocks
    UserController userController;
    @Mock
    private UserService userService;
    @Mock
    private User user;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver;
        viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/pages/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = MockMvcBuilders
                        .standaloneSetup(userController)
                        .setViewResolvers(viewResolver)
                        .build();
    }

    @Test
    public void shouldPrintWelcome() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("message"));
    }

    @Test
    public void shouldGetError() throws Exception{
        mockMvc.perform(get("/error"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attributeExists("errorMessage"));
    }

    @Test
    public void shouldGetPersonalCab() throws Exception{
        mockMvc.perform(get("/personal"))
                .andExpect(status().isOk())
                .andExpect(view().name("personalCab"))
                .andExpect(model().attributeExists("users", "title", "message"));
    }

    @Test
    public void shouldGetMoreDetails() throws Exception{
        mockMvc.perform(get("/moredetails"))
                .andExpect(status().isOk())
                .andExpect(view().name("moreDetails"))
                .andExpect(model().attributeExists("usersdetails", "message"));
    }

    @Test
    public void shouldRedirectToAllUsersAfterDelete() throws Exception{
        mockMvc.perform(post("/deleteUser/10000"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/allusers"))
                .andExpect(model().attributeExists("users"));

    }

}