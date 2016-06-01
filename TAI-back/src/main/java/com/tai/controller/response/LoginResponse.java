package com.tai.controller.response;

import com.tai.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String userID;
    private String token;
    private User user;
}
