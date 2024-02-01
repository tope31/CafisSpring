package com.javakun.exam.service.impl;

import com.javakun.exam.exam.LoginFailedException;
import com.javakun.exam.model.User;
import com.javakun.exam.service.UserService;
import com.javakun.exam.util.MD5Hash;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import static com.javakun.exam.model.StaticUserList.users;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User login(String authorizationHeader) {
        String base64Credentials = authorizationHeader.substring("Basic ".length()).trim();

        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);

        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];
        MD5Hash md5Hash = new MD5Hash();
        String hashedPassword = md5Hash.toMD5(password);

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(hashedPassword)) {
                return user;
            }
        }
            throw new LoginFailedException();
    }
}
