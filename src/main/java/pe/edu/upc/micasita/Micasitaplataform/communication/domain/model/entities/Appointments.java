package pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;

import java.time.LocalDateTime;

@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Properties properties;

    private LocalDateTime dateTime;
    private String status;
}