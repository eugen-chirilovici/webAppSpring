package com.springapp.mvc.model.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSession {

    private LoginInfo loginInfo;
    private Session session;


}
