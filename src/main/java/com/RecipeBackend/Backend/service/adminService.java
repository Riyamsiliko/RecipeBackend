package com.RecipeBackend.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.RecipeBackend.Backend.model.admin;
import com.RecipeBackend.Backend.repository.adminRepository;
@Service
public class adminService {
    @Autowired
    private adminRepository aRepository;
    
    public admin createAdmin(admin admin) {
        return aRepository.save(admin) ;
    }

   
    public List<admin> getAllAdmins() {
        return aRepository.findAll() ;
    }


    public Admin createAdmin(Admin admin) {
        return null;
    }
}
