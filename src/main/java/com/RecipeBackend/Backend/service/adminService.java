package com.RecipeBackend.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecipeBackend.Backend.model.admin;
import com.RecipeBackend.Backend.repository.adminRepository;
@Service
public class adminService {
    @Autowired
    private adminRepository aRepository;
    
    

    public admin createAdmin(admin Admin) {
        return aRepository.save(Admin) ;
    }
   
    public List<admin> getAllAdmins() {
        return aRepository.findAll() ;
    }


    public admin getAdminById(Integer id){
        Optional<admin> Admin= aRepository.findById(id);
        return Admin.get();
    }

    public void deleteAdmin(Integer id){
        aRepository.deleteById(id);
    }

    public admin updateAdmin(admin Admin){
        admin updateadmin = aRepository.findById(Admin.getId()).get();
        updateadmin.setAdminname(Admin.getAdminname());
        updateadmin.setEmail(Admin.getEmail());
        updateadmin.setPassword(Admin.getPassword());

        
        return aRepository.save(updateadmin);
    }

}
