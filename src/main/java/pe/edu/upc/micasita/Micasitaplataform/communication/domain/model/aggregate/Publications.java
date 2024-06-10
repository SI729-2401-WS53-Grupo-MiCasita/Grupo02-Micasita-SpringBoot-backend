package pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;

import java.time.LocalDateTime;

@Entity
public class Publications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

    private LocalDateTime publicationDate;
    private int commentsId;
}