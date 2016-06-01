package com.tai.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Wrong login/password combination")
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String msg){
        super(msg);
    }
}
