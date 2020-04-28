import com.springapp.mvc.dao.CredentialsDAO;
import com.springapp.mvc.dto.CredentialsDTO;
import com.springapp.mvc.model.Credentials;
import com.springapp.mvc.model.enums.RoleType;
import com.springapp.mvc.service.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AuthenticationServiceTest {

    @Mock
    private CredentialsDAO mockCredentialsDAO;

    @InjectMocks
    private AuthenticationService authenticationServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testConfirmAuthentication() {
        final CredentialsDTO credentials = new CredentialsDTO();
        credentials.setLogin("login");
        credentials.setPassword("password");

        final Credentials expectedResult = new Credentials(0L, "login", "password", RoleType.ROLE_ADMIN);

        final Optional<Credentials> credentials1 = Optional.of(new Credentials(0L, "login", "password", RoleType.ROLE_ADMIN));
        when(mockCredentialsDAO.validateUser(any(CredentialsDTO.class))).thenReturn(credentials1);

        final Credentials result = authenticationServiceUnderTest.confirmAuthentication(credentials);

        assertEquals(expectedResult, result);
    }
}
