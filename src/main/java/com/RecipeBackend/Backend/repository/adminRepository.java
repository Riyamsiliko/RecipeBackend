package com.RecipeBackend.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RecipeBackend.Backend.model.admin;

@Repository
public interface adminRepository extends JpaRepository<admin,Integer> {

    
} 
