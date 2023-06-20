package com.RecipeBackend.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecipeBackend.Backend.model.Recipe;
import com.RecipeBackend.Backend.repository.recipeRepository;
@Service
public class recipeService {
    @Autowired
    private recipeRepository rRepository;
    
    public Recipe createRecipe(Recipe recipe) {
        return rRepository.save(recipe) ;
    }

   
    public List<Recipe> getAllRecipes() {
        return rRepository.findAll() ;
    }
}
