package com.springapp.mvc.service.jira;

import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.model.jira.IssueResponse;
import com.springapp.mvc.model.jira.issue.EditedIssue;
import com.springapp.mvc.model.jira.issue.Issue;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public interface IssueService {

    HttpEntity createIssue(Issue issue) throws CustomUserException;

    String deleteIssueById(String id) throws CustomUserException;

    HttpEntity updateIssueById(String id, EditedIssue issue) throws CustomUserException;

    ResponseEntity<String> getIssuesAssignedTo(String user);

}
