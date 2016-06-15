package com.tai.controller.request;

import lombok.Data;

@Data
public class EditUserRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String login;
    private String password;

}
