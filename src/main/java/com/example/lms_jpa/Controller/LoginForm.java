package com.example.lms_jpa.Controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginForm {
    @NotEmpty
    private String user_id;
    @NotEmpty
    private String password;
}
