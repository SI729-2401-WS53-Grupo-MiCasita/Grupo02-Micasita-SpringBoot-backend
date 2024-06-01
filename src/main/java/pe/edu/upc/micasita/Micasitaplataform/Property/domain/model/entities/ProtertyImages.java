package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects.PropertyID;

import java.util.Properties;


public class ProtertyImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    @Embedded
    private PropertyID propertyID;

    @ManyToOne
    @JoinColumn(name = "property_id") // Adjust the column name as needed
    private Properties property;


}
