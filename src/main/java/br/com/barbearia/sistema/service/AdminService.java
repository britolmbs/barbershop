package br.com.barbearia.sistema.service;

import br.com.barbearia.sistema.model.Admin;
import br.com.barbearia.sistema.repository.AdminRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRespository adminRespository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin createAdmin(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRespository.save(admin);

    }
    public List<Admin> getAllAdmins(){
        return adminRespository.findAll();
    }
    public Admin getAdminById(Long id){
        return adminRespository.findById(id).orElseThrow(()-> new RuntimeException("Admin não encontrado"));

    }

    public Admin updateAdmin(Long id, Admin adminDetails){
        Admin admin = getAdminById(id);
        admin.setUsername(adminDetails.getUsername());
        admin.setEmail(adminDetails.getEmail());
        admin.setPassword(passwordEncoder.encode(adminDetails.getPassword()));
        return  adminRespository.save(admin);
    }

    public void deleteAdmin(Long id){
        Admin admin = getAdminById(id);
        adminRespository.delete(admin);
    }

}
