package com.tai.controller.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterRequest {
    @NonNull private String firstname;
    @NonNull private String lastname;
    @NonNull private String login;
    @NonNull private String email;
    @NonNull private String password;
}
