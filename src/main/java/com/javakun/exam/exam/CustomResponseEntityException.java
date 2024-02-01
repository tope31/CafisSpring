package com.javakun.exam.exam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LoginFailedException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException() {
        ErrorDetails errorDetails = new ErrorDetails("Login Failed!");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
