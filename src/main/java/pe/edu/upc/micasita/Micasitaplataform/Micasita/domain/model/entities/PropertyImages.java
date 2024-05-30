package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "property_images")
@Data
public class PropertyImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertiesImpl property;


}