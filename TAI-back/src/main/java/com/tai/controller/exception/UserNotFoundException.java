package com.tai.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User with given username doesn't exist")
public class UserNotFoundException extends RuntimeException {

    private String username;

    public UserNotFoundException(String username){
        super(username + " not found");
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
