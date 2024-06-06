package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Price;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Status;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects.SellerID;



@Setter
@Getter
@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;


    @Column(name = "price")
    private Long price;

    @Column(length = 50)
    private String location;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "status"))
    private Status status;

    @Column(length = 15)
    private String type;

    @Column(precision = 15, scale = 2)
    private Long size;

    private Integer bedrooms;

    private Integer bathrooms;

    private Integer garageSpace;

    private Integer yearBuilt;

    @Embedded
    private SellerID sellerID;

    public void updateInformation(Properties propertyDetails) {
        this.title = propertyDetails.title;
        this.description = propertyDetails.description;
        this.price = propertyDetails.price;
        this.location = propertyDetails.location;
        this.status = propertyDetails.status;
        this.type = propertyDetails.type;
        this.size = propertyDetails.size;
        this.bedrooms = propertyDetails.bedrooms;
        this.bathrooms = propertyDetails.bathrooms;
        this.garageSpace = propertyDetails.garageSpace;
        this.yearBuilt = propertyDetails.yearBuilt;
        this.sellerID = propertyDetails.sellerID;
    }

    public void changeStatus(String newStatus) {
        this.status = new Status(newStatus);
    }

    public void changePrice(Long newPrice) {
        this.price = newPrice;
    }

    public void changeType(String newType) {
        this.type = newType;
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
    }

    public void changeLocation(String newLocation) {
        this.location = newLocation;
    }
}