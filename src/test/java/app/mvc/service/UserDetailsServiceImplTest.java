package app.mvc.service;

import app.mvc.dao.CredentialsDAO;
import app.mvc.model.Credentials;
import app.mvc.model.enums.RoleType;
import app.mvc.util.CredentialsUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.internal.CredentialsUtil;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest()
class UserDetailsServiceImplTest {

    @Mock
    private CredentialsDAO mockCredentialsDao;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }


    @Test
    void testLoadUserByUsername() {
        final Optional<Credentials> credentials = Optional.of(CredentialsUtils.createCredentialsForUserRole());
        when(mockCredentialsDao.findByUsername("dsadsa")).thenReturn(credentials);
        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsServiceImplUnderTest.loadUserByUsername(CredentialsUtils.createCredentialsForUserRole().getUsername());
        });
    }
}
