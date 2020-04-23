package com.springapp.mvc.model;

import com.springapp.mvc.model.enums.RoleType;
import lombok.*;

import java.util.Objects;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
    private long id;
    private String username;
    private String password;
    private RoleType role;
}