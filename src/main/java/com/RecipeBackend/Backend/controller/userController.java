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

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = uService.getuserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        uService.deleteUser(id);
        return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    }



    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user){
        user.setId(id);
        User updatedUser = uService.updateUser(user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}