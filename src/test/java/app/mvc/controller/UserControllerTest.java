package app.mvc.controller;

import app.mvc.dto.DeleteUserDTO;
import app.mvc.model.User;
import app.mvc.service.AuthenticationService;
import app.mvc.service.UserService;
import app.mvc.util.UserUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
class UserControllerTest {

    @Mock
    private UserService mockUserService;
    @Mock
    private AuthenticationService mockAuthenticationService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        assertThat(userController).isNotNull();

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @Test
    void testDeleteUser() {
        final DeleteUserDTO deleteUserDTO = new DeleteUserDTO();
        User user = UserUtils.createUser();
        deleteUserDTO.setRequiredID_Delete(Math.toIntExact(user.getUserId()));

        when(mockAuthenticationService.IDlength()).thenReturn(user.getUserId());

        final String result = userController.deleteUser(deleteUserDTO);

        assertEquals("redirect:/allusers", result);
        verify(mockUserService).deleteUser(user.getUserId());
    }


    @Test
    @WithMockUser(username = "frosca")
    public void shouldGetParsedData() throws Exception {
        mockMvc.perform(get("/welcome")).andExpect(status().is3xxRedirection());
        mockMvc.perform(get("/parsedData"))
                .andExpect(status().isOk())
                .andExpect(view().name("parsedData"))
                .andExpect(model().attributeExists("user"));
    }


    @Test
    @WithMockUser(username = "frosca")
    public void shouldReturnMoreDetailsPage() throws Exception {
        mockMvc.perform(get("/moreDetails"))
                .andExpect(status().isOk())
                .andExpect(view().name("moreDetails"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attributeExists("title"))
                .andExpect(model().attributeExists("message"));
    }
}
