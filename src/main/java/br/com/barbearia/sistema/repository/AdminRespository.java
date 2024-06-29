package br.com.barbearia.sistema.repository;

import br.com.barbearia.sistema.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRespository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);
    Optional<Admin> findByEmail(String email);
}
