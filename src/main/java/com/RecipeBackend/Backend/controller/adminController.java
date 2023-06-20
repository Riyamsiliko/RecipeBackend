package com.RecipeBackend.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecipeBackend.Backend.model.admin;
import com.RecipeBackend.Backend.service.adminService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class adminController {
    @Autowired
    private adminService aService;

    @PostMapping("/admin")
    public ResponseEntity<Admin> createRecipe(@RequestBody Admin admin) {
       Admin createdAdmin = aService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public List<admin> getAllAdmins() {
        return aService.getAllAdmins();
    }
}
