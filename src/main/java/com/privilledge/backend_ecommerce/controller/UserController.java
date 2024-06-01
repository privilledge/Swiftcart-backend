package com.privilledge.backend_ecommerce.controller;

import com.privilledge.backend_ecommerce.model.User;
import com.privilledge.backend_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Use RestController for returning responses directly
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        userService.saveUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findUserByEmail(email);
        if (user != null ) {
            return "Login successful";
        }
        return "Invalid username or password";
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
