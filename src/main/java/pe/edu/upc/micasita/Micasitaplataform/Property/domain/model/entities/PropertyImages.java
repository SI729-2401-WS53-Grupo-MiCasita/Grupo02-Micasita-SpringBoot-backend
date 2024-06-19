package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Property;

@Setter
@Getter
@Entity
public class PropertyImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    public String url;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

}