package com.RecipeBackend.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RecipeBackend.Backend.model.Recipe;
@Repository
public interface recipeRepository extends JpaRepository<Recipe, Integer>  {
    
}
