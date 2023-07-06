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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecipeBackend.Backend.model.Recipe;
import com.RecipeBackend.Backend.service.recipeService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000") // Add the appropriate origin URL
public class recipeController {
    @Autowired
    private recipeService rService;



    @PostMapping("/add")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe createdRecipe = rService.createRecipe(recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.OK);
    }

    @GetMapping("/recipe")
    public List<Recipe> getAllRecipes() {
        return rService.getAllRecipes();
    }

    @GetMapping("/recipe/count")
    public ResponseEntity<Long> countRecipe(){
        long recipecount = rService.countrecipe();
        return new ResponseEntity<>(recipecount, HttpStatus.OK);
    }

    @GetMapping("/recipe/title")
    public ResponseEntity<Long> counttitle(){
        long recipecount = rService.countrecipe();
        return new ResponseEntity<>(recipecount, HttpStatus.OK);
    }

    @GetMapping("/recipe/ingredients(")
    public ResponseEntity<Long> countingredients(){
        long recipecount = rService.countrecipe();
        return new ResponseEntity<>(recipecount, HttpStatus.OK);
    }

    @GetMapping("/recipe/instructions")
    public ResponseEntity<Long> countinstructions(){
        long recipecount = rService.countrecipe();
        return new ResponseEntity<>(recipecount, HttpStatus.OK);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id){
        Recipe recipe = rService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Integer id){
        rService.deleteRecipe(id);
        return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    }



    @PutMapping("/recipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") Integer id, @RequestBody Recipe recipe){
        recipe.setId(id);
        Recipe updaterecipe = rService.updateRecipe(recipe);
        if (updaterecipe != null) {
            return new ResponseEntity<>(updaterecipe, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    
}
