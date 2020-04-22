package com.springapp.mvc.service;

import com.springapp.mvc.model.jira.CurrentUser;
import org.springframework.http.ResponseEntity;

public interface JiraUserService {

    public void getSession();

    public ResponseEntity<CurrentUser> getCurrentUser();

}
