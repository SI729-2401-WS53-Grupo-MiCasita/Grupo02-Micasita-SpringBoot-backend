package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.PropertyId;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.UserId;


@Setter
@Getter
@Entity
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private PropertyId propertyId;

    @Embedded
    private UserId userId;

}

