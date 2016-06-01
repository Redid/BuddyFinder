package com.tai.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Login already exists")
public class LoginNotUniqueException extends RuntimeException {
}
