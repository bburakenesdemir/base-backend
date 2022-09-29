package com.burakenesdemir.basebackend.controller;

import com.burakenesdemir.basebackend.model.dto.UserDTO;
import com.burakenesdemir.basebackend.model.mongo.User;
import com.burakenesdemir.basebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserDTO.RegisterDto registerDto) {
        return new ResponseEntity<>(userService.register(new User(registerDto)), HttpStatus.OK);
    }
}
