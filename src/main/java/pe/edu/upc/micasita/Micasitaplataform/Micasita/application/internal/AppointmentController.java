package pe.edu.upc.micasita.Micasitaplataform.Micasita.application.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.Appointment;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {
  @Autowired
  private AppointmentService appointmentService;

  @GetMapping
  public List<Appointment> getAllAppointments() {
    return appointmentService.getAllAppointments();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer id) {
    Appointment appointment = appointmentService.getAppointmentById(id);

    if (appointment != null) {
      return ResponseEntity.ok(appointment);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public Appointment craeteAppointment(@RequestBody Appointment appointment) {
    return appointmentService.createAppointment(appointment);
  } 
  
  @PutMapping("/{id}")
  public ResponseEntity<Appointment> updateAppointemnt(@PathVariable Integer id, @RequestBody Appointment appointmentDetails) {
    Appointment updateAppointment = appointmentService.updateAppointment(id, appointmentDetails);
    if (updateAppointment != null) {
      return ResponseEntity.ok(updateAppointment);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAppointment(@PathVariable Integer id) {
    appointmentService.deleteAppointment(id);
    return ResponseEntity.noContent().build();
  }
}
