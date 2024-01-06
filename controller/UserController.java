package com.example.UserLoginSystem.controller;

import com.example.UserLoginSystem.model.User;
import com.example.UserLoginSystem.model.dto.SignInInputDto;
import com.example.UserLoginSystem.model.dto.SignInOutPut;
import com.example.UserLoginSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("signUp/user")
    public String signUp(@RequestBody User user) throws NoSuchAlgorithmException {
       return userService.signUpUser(user);
    }

    @PostMapping("signIn")
    public String signIn(@RequestBody SignInInputDto signInInputDto) throws NoSuchAlgorithmException {
       return userService.signIn(signInInputDto);
    }
}
