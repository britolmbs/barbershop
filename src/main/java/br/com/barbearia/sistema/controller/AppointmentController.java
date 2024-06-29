package br.com.barbearia.sistema.controller;

import br.com.barbearia.sistema.model.Appointment;
import br.com.barbearia.sistema.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment){
       Appointment createdAppointment = appointmentService.createAppointment(appointment);
       return ResponseEntity.ok(createdAppointment);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Appointment> getAppointmentBydId(@PathVariable Long id){
        Appointment appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails){
        Appointment updateAppointment = appointmentService.updateAppointment(id, appointmentDetails);
        return ResponseEntity.ok(updateAppointment);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
