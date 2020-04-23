package com.springapp.mvc.model.jira.issue;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fields {

    @JsonProperty("project")
    private Project project;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("issuetype")
    private IssueType issuetype;

    @JsonProperty("assignee")
    private Assignee assignee;

    @JsonProperty("reporter")
    private Reporter reporter;

    @JsonProperty("labels")
    private List<String> labels;

    @JsonProperty("description")
    private String description;

    @JsonProperty("components")
    private List<Component> components;

}
