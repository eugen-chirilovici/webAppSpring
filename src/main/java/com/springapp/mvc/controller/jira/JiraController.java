package com.springapp.mvc.controller.jira;


import com.springapp.mvc.exceptionsHandlers.CustomUserException;
import com.springapp.mvc.model.jira.CurrentUser;
import com.springapp.mvc.service.JiraUserService;
import com.springapp.mvc.service.JiraUserServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@RequestMapping("/jira/create_new_session")
public class JiraController {

    @Autowired
    private JiraUserServiceImpl jiraUserService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity createNewSession() throws CustomUserException {
        try {
            jiraUserService.getSession();
            return new ResponseEntity<>("Success.", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomUserException("Session creating error.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/get_current_user", method = RequestMethod.GET)
    public ResponseEntity<CurrentUser> getCurrentUser() throws CustomUserException {
        try {
            ResponseEntity<CurrentUser> currentUser = jiraUserService.getCurrentUser();
            return currentUser;
        } catch (Exception e) {
            throw new CustomUserException("There's not session opened.", HttpStatus.FORBIDDEN);
        }
    }

}
