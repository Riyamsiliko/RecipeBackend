package com.RecipeBackend.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String title;
private String ingredients;
private String instructions;    
}
