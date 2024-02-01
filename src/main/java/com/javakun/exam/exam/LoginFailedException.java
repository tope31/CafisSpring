package com.javakun.exam.exam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LoginFailedException extends RuntimeException {
    public LoginFailedException() {
    }
}
