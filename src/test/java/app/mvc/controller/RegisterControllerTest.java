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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest()
class RegisterControllerTest {

    @Mock
    private RegisterService registerService;

    @InjectMocks
    private RegisterController registerController;

    @BeforeEach
    void setUp() {
        initMocks(this);
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
