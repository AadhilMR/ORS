package com.kanishka.ors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanishka.ors.dto.UserDTO;
import com.kanishka.ors.service.UserService;

@RestController
@RequestMapping("/user")
public class RegistrationController {
    @Autowired
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        boolean isUserRegistered = userService.register(userDTO);

        if(isUserRegistered) {
            return ResponseEntity.ok("User is registered successfully! You can login now.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong! Please try again.");
        }
    }
}
