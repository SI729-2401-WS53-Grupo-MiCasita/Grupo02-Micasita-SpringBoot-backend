package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects.SellerID;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Properties {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal price;
    private String location;
    private String status;
    private String type;
    private BigDecimal size;
    private int bedrooms;
    private int bathrooms;
    private int garageSpace;
    private int yearBuilt;

    @Embedded
    private SellerID sellerID;

}
