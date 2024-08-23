package com.kanishka.ors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanishka.ors.entity.User;
import com.kanishka.ors.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam("username") String username,
                                            @RequestParam("password") String password,
                                            HttpServletRequest request) {
        User loginUser = userService.login(username, password);

        if(loginUser != null) {
            // Set the session for user object
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", loginUser);

            return ResponseEntity.ok("Login is success!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exists! Please register first.");
        }
    }
}
