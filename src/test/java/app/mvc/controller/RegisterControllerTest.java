package app.mvc.controller;

import app.mvc.dto.UserRegistDTO;
import app.mvc.service.RegisterService;
import app.mvc.service.UserService;
import app.mvc.util.UserRegistDTOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
class RegisterControllerTest {

    @Mock
    private UserService mockUserService;

    @Autowired
    private WebApplicationContext context;

    @Mock
    private RegisterService registerService;

    @InjectMocks
    private RegisterController registerController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        assertThat(registerController).isNotNull();
        initMocks(this);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

    }

    @Test
    @WithMockUser
    void shouldGetRegisterPage() throws Exception {
        mockMvc.perform(get("/regist"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("message"));
    }

    @Test
    void shouldRegistNewUser() {
        final UserRegistDTO userRegistDTO = UserRegistDTOUtils.registUser();
        when((registerService.loginValidator(userRegistDTO.getUsername()))).thenReturn(false);
        final String expectedResult = registerController.registNewUser(userRegistDTO);
        assertEquals("index",expectedResult);
        verify(registerService).addRegisterUser(UserRegistDTOUtils.registUser());
    }

    @Test
    void shouldnRegistNewUserWithInvalidData() {
        final UserRegistDTO userRegistDTO = UserRegistDTOUtils.createInvalidUser();
        when(registerService.loginValidator(userRegistDTO.getUsername())).thenReturn(false);
        final String result = registerController.registNewUser(userRegistDTO);
        assertEquals("error", result);
    }
}
