package pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.valueobjects.UserID;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eventType;

    @Embedded
    private UserID userId;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;


    private LocalDateTime eventDate;
    private String status;

}
