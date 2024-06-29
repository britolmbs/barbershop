package br.com.barbearia.sistema.service;

import br.com.barbearia.sistema.model.Appointment;
import br.com.barbearia.sistema.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return  appointmentRepository.findAll();
    }
    public Appointment getAppointmentById(Long id){
        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("compromisso não encontrado"));
    }
    public Appointment updateAppointment(Long id, Appointment appointmentDetails){
        Appointment appointment = getAppointmentById(id);
        appointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
        appointment.setServiceType(appointmentDetails.getServiceType());
        appointment.setNotes(appointmentDetails.getNotes());
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id){
        Appointment appointment = getAppointmentById(id);
        appointmentRepository.delete(appointment);
    }
}
