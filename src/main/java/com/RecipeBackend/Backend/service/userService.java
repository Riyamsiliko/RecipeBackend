package com.RecipeBackend.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecipeBackend.Backend.model.User;
import com.RecipeBackend.Backend.repository.userRepository;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;

   
    public User createUser(User user) {
        // Add any required business logic or validation before saving the user
        return userRepository.save(user);
    }

   
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
