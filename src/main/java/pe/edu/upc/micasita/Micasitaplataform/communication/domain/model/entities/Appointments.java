package pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.valueobjects.PropertyID;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.valueobjects.UserID;


import java.time.LocalDateTime;

@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private UserID userId;


    @Embedded
    private PropertyID propertyId;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

    private LocalDateTime dateTime;
    private String status;


}
