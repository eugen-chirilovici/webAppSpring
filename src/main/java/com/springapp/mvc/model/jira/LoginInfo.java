package com.springapp.mvc.model.jira;

import lombok.Data;

@Data
public class LoginInfo {
    private int failedLoginCount;
    private int loginCount;
    private String lastFailedLoginTime;
    private String previousLoginTime;


}
