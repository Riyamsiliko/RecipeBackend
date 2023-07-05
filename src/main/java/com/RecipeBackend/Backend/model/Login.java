package com.RecipeBackend.Backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Login {
    @Id
    private String username;
    private String password;
    private String user_role;
}
