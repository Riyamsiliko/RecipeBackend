package com.RecipeBackend.Backend.controller;

import com.RecipeBackend.Backend.model.Login;
import com.RecipeBackend.Backend.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins ="http://localhost:3000")
public class LoginAPI {
    @Autowired
    private LoginRepo loginRepo;

    @GetMapping("/all")
    public ResponseEntity<?> getAlluser(){
        try {
            List<Login> loginList = loginRepo.findAll();

            if(loginList.isEmpty()){
                return new ResponseEntity<>("No Data",HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(loginList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Error Connection",HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/id/{username}")
    public ResponseEntity<?> getById(@PathVariable String username){
        try {
            Optional<Login> optionalLogin = loginRepo.findById(username);
            if (optionalLogin.isPresent()){
                return new ResponseEntity<>(optionalLogin,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("No Connection",HttpStatus.BAD_GATEWAY);
        }
    }
}
