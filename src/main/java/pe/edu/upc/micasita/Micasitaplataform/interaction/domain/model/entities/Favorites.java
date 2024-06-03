package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects.PropertiesID;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects.UserID;

@Entity
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private UserID userID;
    @Embedded
    private PropertiesID propertiesID;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;
}
