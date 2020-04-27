package com.springapp.mvc.controller.jira;


import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.model.jira.CurrentUser;
import com.springapp.mvc.service.jira.JiraUserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@RequestMapping("/jira/user")
public class JiraController {

    @Autowired
    private JiraUserServiceImpl jiraUserService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity createNewSession() throws CustomUserException {
        try {
           return jiraUserService.getSession();
            //return new String("Success.");
        } catch (Exception e) {
            throw new CustomUserException("Error while creating session", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public ResponseEntity<CurrentUser> getCurrentUser() throws CustomUserException {
        try {
            ResponseEntity<CurrentUser> currentUser = jiraUserService.getCurrentUser();
            return currentUser;
        } catch (Exception e) {
            throw new CustomUserException("There's not session opened.", HttpStatus.FORBIDDEN);
        }
    }

}
