package com.springapp.mvc.service.jira;

import com.springapp.mvc.model.jira.CurrentUser;
import org.springframework.http.ResponseEntity;

public interface JiraUserService {

    public ResponseEntity getSession();

    public ResponseEntity<CurrentUser> getCurrentUser();

}
