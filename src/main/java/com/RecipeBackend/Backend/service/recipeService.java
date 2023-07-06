package com.RecipeBackend.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecipeBackend.Backend.model.Recipe;
import com.RecipeBackend.Backend.repository.recipeRepository;
@Service
public class recipeService {
    @Autowired
    private recipeRepository rRepository;
    
    public long counttitle(){
        return rRepository.count();
    }

    public long countrecipe(){
        return rRepository.count();
    }

    public long countingredients(){
        return rRepository.count();
    }

    public long countinstructions(){
        return rRepository.count();
    }
    public Recipe createRecipe(Recipe recipe) {
        return rRepository.save(recipe) ;
    }

   
    public List<Recipe> getAllRecipes() {
        return rRepository.findAll() ;
    }

    public Recipe getRecipeById(Integer id){
        Optional<Recipe> recipe= rRepository.findById(id);
        return recipe.get();
    }

    public void deleteRecipe(Integer id){
        rRepository.deleteById(id);
    }

    public Recipe updateRecipe(Recipe recipe){
        Recipe updaterecipe = rRepository.findById(recipe.getId()).get();
        updaterecipe.setIngredients(recipe.getIngredients());
        updaterecipe.setTitle(recipe.getTitle());

        updaterecipe.setInstructions(recipe.getInstructions());

        
        return rRepository.save(updaterecipe);

    }
    public static List<Recipe> searchRecipesByTitle(String query) {
        return null;
    }
}
