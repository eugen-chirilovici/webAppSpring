package com.springapp.mvc.service.jira;

import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.model.jira.Session;
import com.springapp.mvc.model.jira.issue.*;
import com.springapp.mvc.model.jira.IssueResponse;
import com.springapp.mvc.model.jira.SessionValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.springapp.mvc.utils.URLS.CREATE_ISSUE_POST;
import static com.springapp.mvc.utils.URLS.DELETE_ISSUE_BY_ID;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    JiraUserServiceImpl jiraUserService;

    @Autowired
    RestTemplate restTemplate;



    @Override
    public HttpEntity createIssue(Issue issue) throws CustomUserException {
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie","JSESSIONID=" + sessionValue.getSessionValue());
        try {
            HttpEntity request = new HttpEntity<>(issue, headers);
            return restTemplate.exchange(CREATE_ISSUE_POST, HttpMethod.POST, request, IssueResponse.class);
        } catch (Exception e) {
            throw new CustomUserException("Issue wasn't created. Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String deleteIssueById(String id) throws CustomUserException {
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie","JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity(headers);
        try {
            restTemplate.exchange(DELETE_ISSUE_BY_ID.concat(id), HttpMethod.DELETE, request, String.class);
            return "Issue with id " + id + " was deleted.";
        } catch (Exception e) {
            throw new CustomUserException("Issue wasn't deleted", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
    }

    @Override
    public HttpEntity updateIssueById(String id, EditedIssue issue) throws CustomUserException {
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        try {
            HttpEntity request = new HttpEntity<>(issue, headers);
            return restTemplate.exchange(CREATE_ISSUE_POST.concat(id), HttpMethod.PUT, request, String.class);
        } catch (Exception e) {
            throw new CustomUserException("Issue wasn't updated. Internal error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> getIssuesAssignedTo(String user) {
        String url = "https://uatjira.endava.com/rest/api/2/search?jql=project=JIS AND assignee=" + user;
        jiraUserService.getSession();
        SessionValue sessionValue = jiraUserService.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie","JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity(headers);
        return restTemplate.exchange(url, HttpMethod.GET, request, String.class);
    }
}
