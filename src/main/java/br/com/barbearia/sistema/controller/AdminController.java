package br.com.barbearia.sistema.controller;

import br.com.barbearia.sistema.model.Admin;
import br.com.barbearia.sistema.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
     Admin createdAdmin = adminService.createAdmin(admin);
     return ResponseEntity.ok(createdAdmin);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById (@PathVariable Long id){
     Admin admin = adminService.getAdminById(id);
     return ResponseEntity.ok(admin);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails){
        Admin updateAdmin = adminService.updateAdmin(id, adminDetails);
        return ResponseEntity.ok(updateAdmin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
