package pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.valueobjects.PropertyID;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.valueobjects.UserID;

import java.time.LocalDateTime;
@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eventType;

    @Embedded
    private UserID userId;
    @Embedded
    private PropertyID propertyId;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

    private LocalDateTime eventDate;
    private String status;

}
