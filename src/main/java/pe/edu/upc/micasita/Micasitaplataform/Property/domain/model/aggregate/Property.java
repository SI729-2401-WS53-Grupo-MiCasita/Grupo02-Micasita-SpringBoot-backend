package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.AddPropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects.PropertyStatus;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects.PropertyType;
import pe.edu.upc.micasita.Micasitaplataform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;


@Setter
@Getter
@Entity
public class Property extends AuditableAbstractAggregateRoot<Property> {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    */
    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;


    @Column(name = "price")
    private Long price;

    @Column(length = 50)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PropertyStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PropertyType type;



    @Column(precision = 15, scale = 2)
    private Long size;

    private Integer bedrooms;

    private Integer bathrooms;

    private Integer garageSpace;

    private Integer yearBuilt;

    public String getStatus()   {
        return this.status.name();
    }
    public String getType()   {
        return this.type.name();
    }

    public Property() {
    }
    public Property(String title, String description, Long price, String location, String status, String type, Long size, Integer bedrooms, Integer bathrooms, Integer garageSpace, Integer yearBuilt) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.status = PropertyStatus.valueOf(status);
        this.type = PropertyType.valueOf(type);
        this.size = size;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garageSpace = garageSpace;
        this.yearBuilt = yearBuilt;
    }
    public Property(AddPropertyCommand createPropertyCommand) {
        this.title = createPropertyCommand.title();
        this.description = createPropertyCommand.description();
        this.price = createPropertyCommand.price();
        this.location = createPropertyCommand.location();
        this.status = PropertyStatus.valueOf(createPropertyCommand.status());
        this.type = PropertyType.valueOf(createPropertyCommand.type());
        this.size = createPropertyCommand.size();
        this.bedrooms = createPropertyCommand.bedrooms();
        this.bathrooms = createPropertyCommand.bathrooms();
        this.garageSpace = createPropertyCommand.garageSpace();
        this.yearBuilt = createPropertyCommand.yearBuilt();
    }

    public Property updateInformation(String title, String description, Long price, String location, Long size, Integer bedrooms, Integer bathrooms, Integer garageSpace, Integer yearBuilt){
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.size = size;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garageSpace = garageSpace;
        this.yearBuilt = yearBuilt;
        return this;
    }


    public void changeStatus(String status) {
    }

    public void changePrice(Long price) {
    }

    public void changeType(String type) {
    }

    public void changeDescription(String description) {
    }

    public void changeLocation(String location) {
    }
}