package com.tai.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInformationResponse {
    private String login;
    private String firstname;
    private String lastname;
    private String email;
}
