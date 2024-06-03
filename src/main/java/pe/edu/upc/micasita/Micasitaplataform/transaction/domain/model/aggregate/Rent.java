package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserID userID;

    private LocalDateTime dateT;

    private String status;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

}
