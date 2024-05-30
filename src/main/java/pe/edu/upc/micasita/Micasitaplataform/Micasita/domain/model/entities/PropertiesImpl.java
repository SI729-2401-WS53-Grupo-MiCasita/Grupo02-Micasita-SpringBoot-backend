package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Price;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Status;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "properties")
@Data
public class PropertiesImpl implements Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "price"))
    private Price price;

    @Column(length = 50)
    private String location;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "status"))
    private Status status;

    @Column(length = 15)
    private String type;

    @Column(precision = 15, scale = 2)
    private BigDecimal size;

    private Integer bedrooms;

    private Integer bathrooms;

    private Integer garageSpace;

    private Integer yearBuilt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyImages> images;

    @Override
    public List<PropertyImages> getImages() {
        return images;
    }

    @Override
    public void setImages(List<PropertyImages> images) {
        this.images = images;
    }
}