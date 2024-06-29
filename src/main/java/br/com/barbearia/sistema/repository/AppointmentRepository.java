package br.com.barbearia.sistema.repository;

import br.com.barbearia.sistema.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {

    List<Appointment> findByUserId(Long userId);
    List<Appointment> findByAppointmentTimeBetween(LocalDateTime start, LocalDateTime end);
}
