package com.springapp.mvc.service.jira;

import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.model.jira.CurrentUser;
import com.springapp.mvc.model.jira.ResponseSession;
import com.springapp.mvc.model.jira.SessionValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.springapp.mvc.utils.URLS.CREATE_NEW_SESSION;
import static com.springapp.mvc.utils.URLS.GET_LOGGED_USER;


@Service
public class JiraUserServiceImpl implements JiraUserService {

    @Autowired
    RestTemplate restTemplate;

    SessionValue sessionValue = new SessionValue();

    @Value("YourLogin")
    private String username;

    @Value("YourPassword")
    private String password;


    @Override
    public ResponseEntity getSession() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        if (body.isEmpty()) {
            try {
                throw new CustomUserException("Add your credentials, body can't be empty", HttpStatus.EXPECTATION_FAILED);
            } catch (CustomUserException e) {
                e.printStackTrace();
            }
        }
        HttpEntity httpRequest = new HttpEntity<>(body, headers);

        sessionValue.setSessionValue(restTemplate.postForEntity(CREATE_NEW_SESSION, httpRequest, ResponseSession.class)
                .getBody().getSession().getValue());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CurrentUser> getCurrentUser() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(headers);
        return restTemplate.exchange(GET_LOGGED_USER, HttpMethod.GET, request, CurrentUser.class);
    }

}
