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

import com.RecipeBackend.Backend.model.admin;
import com.RecipeBackend.Backend.service.adminService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins ="http://localhost:3000")
public class adminController {
    @Autowired
    private adminService aService;

    @PostMapping("/admin")
    public ResponseEntity<admin> createAdmin(@RequestBody admin Admin) {
       admin createdAdmin = aService.createAdmin(Admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public List<admin> getAllAdmins() {
        return aService.getAllAdmins();
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<admin> getAdminById(@PathVariable Integer id){
        admin Admin = aService.getAdminById(id);
        return new ResponseEntity<>(Admin,HttpStatus.OK);
    }
    
        @DeleteMapping("/admin/{id}")
        public ResponseEntity<String> deleteAdmin(@PathVariable Integer id){
            aService.deleteAdmin(id);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        }



    @PutMapping("/admin/{id}")
    public ResponseEntity<admin> updateAdmin(@PathVariable("id") Integer id, @RequestBody admin Admin){
        Admin.setId(id);
        admin updateAdmin = aService.updateAdmin(Admin);
        if (updateAdmin != null) {
            return new ResponseEntity<>(updateAdmin, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}


