package com.javakun.exam.service;

import com.javakun.exam.model.User;

import java.util.List;

public interface UserService {
    User login(String authHeader);
}
