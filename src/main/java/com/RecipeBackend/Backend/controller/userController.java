package com.RecipeBackend.Backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.RecipeBackend.Backend.model.User;
import com.RecipeBackend.Backend.service.userService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000") // Add the appropriate origin URL
public class userController {

    @Autowired
    private userService uService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = uService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return uService.getAllUsers();
    }
}