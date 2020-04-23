package com.springapp.mvc.model.jira.issue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Warklog {

    @JsonProperty("add")
    private Add add;

}
