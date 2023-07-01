package com.RecipeBackend.Backend.service;

import java.util.List;
import java.util.Optional;

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

    public User getuserById(Integer id){
        Optional<User> user= userRepository.findById(id);
        return user.get();
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        User updateuser = userRepository.findById(user.getId()).get();
        updateuser.setUsername(user.getUsername());
        updateuser.setEmail(user.getEmail());
        updateuser.setPassword(user.getPassword());
  
        return userRepository.save(updateuser);

    }
}
