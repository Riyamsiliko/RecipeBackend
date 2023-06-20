package com.RecipeBackend.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecipeBackend.Backend.model.Recipe;
import com.RecipeBackend.Backend.service.recipeService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000") // Add the appropriate origin URL
public class recipeController {
    @Autowired
    private recipeService rService;

    @PostMapping("/recipe")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = rService.createRecipe(recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.OK);
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return rService.getAllRecipes();
    }


@DeleteMapping("/deleteReceipt/{id}")
    public ResponseEntity<Recipe> updateReceipt(@PathVariable Integer id  )
    
}
