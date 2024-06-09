package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;


import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.PropertyID;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.time.LocalDateTime;

@Entity
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserID userID;

    private LocalDateTime dateTime;

    private Long amount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

}
