package com.RecipeBackend.Backend.repository;

import com.RecipeBackend.Backend.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<Login,String> {
}
