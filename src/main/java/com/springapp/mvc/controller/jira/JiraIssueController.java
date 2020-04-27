package com.springapp.mvc.controller.jira;

import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.model.jira.IssueResponse;
import com.springapp.mvc.model.jira.issue.EditedIssue;
import com.springapp.mvc.model.jira.issue.Issue;
import com.springapp.mvc.service.jira.IssueServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/jira/issues")
public class JiraIssueController {

    @Autowired
    private IssueServiceImpl issueService;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public HttpEntity createIssue(@RequestBody Issue issue) throws CustomUserException {
        try {
            issueService.createIssue(issue);
            return new ResponseEntity<>("Issue was created.", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomUserException("Error. Issue wasn't created.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public HttpEntity updateIssue(@PathVariable String id, @RequestBody EditedIssue issue) throws CustomUserException {
        try {
            issueService.updateIssueById(id, issue);
            return new ResponseEntity("Issue " + id + " was updated", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomUserException("Issue wasn't updated.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteIssue(@PathVariable String id) throws CustomUserException {
        try {
            return issueService.deleteIssueById(id);
        } catch (Exception e) {
            throw new CustomUserException("Error. Issue wasn't deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/find/{user}", method = RequestMethod.GET)
    public ResponseEntity<String> getIssuesByUser(@PathVariable String user) throws CustomUserException {
        try {
            return issueService.getIssuesAssignedTo(user);
        } catch (Exception e) {
            throw new CustomUserException("Error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
