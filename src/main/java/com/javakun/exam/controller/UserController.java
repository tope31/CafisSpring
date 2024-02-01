package com.javakun.exam.controller;

import com.javakun.exam.model.User;
import com.javakun.exam.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<User> userLogin(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        return new ResponseEntity<>(userService.login(authorizationHeader), HttpStatus.OK);
    }
}
