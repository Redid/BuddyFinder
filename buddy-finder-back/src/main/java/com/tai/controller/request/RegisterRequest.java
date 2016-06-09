package com.tai.controller.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String login;
    private String email;
    private String password;
}
