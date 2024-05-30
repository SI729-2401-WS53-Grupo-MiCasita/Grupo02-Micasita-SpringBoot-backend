package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;

import org.springframework.stereotype.Service;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.AppointmentRepository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.Appointment;

import java.util.List;

@Service
public class AppointmentService {
  private final AppointmentRepository appointmentRepository;

  public AppointmentService(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
    
  }

  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  public Appointment getAppointmentById(Integer id) {
    return appointmentRepository.findById(id).orElse(null);
  }

  public Appointment createAppointment(Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  public Appointment updateAppointment(Integer id, Appointment appointmentDetails) {
    Appointment appointment = appointmentRepository.findById(id).orElse(null);
    if (appointment != null) {
      appointment.setDateTime(appointmentDetails.getDateTime());
      appointment.setProperty(appointmentDetails.getProperty());
      appointment.setUser(appointmentDetails.getUser());
      return appointmentRepository.save(appointment);
    }
    return null;
  }

  public void deleteAppointment(Integer id) {
    appointmentRepository.deleteById(id);
  }
}
