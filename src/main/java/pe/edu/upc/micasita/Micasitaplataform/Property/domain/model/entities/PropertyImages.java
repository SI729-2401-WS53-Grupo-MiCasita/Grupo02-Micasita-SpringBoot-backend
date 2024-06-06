package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;

@Entity
public class PropertyImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties property;

    // Rest of your fields...
}