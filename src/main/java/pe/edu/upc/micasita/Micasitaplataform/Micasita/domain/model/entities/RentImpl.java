package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Rent;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.DateTime;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Status;


@Entity
@Table(name = "rents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentImpl implements Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private PropertiesImpl property;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "date", nullable = false))
    private DateTime date;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "status", nullable = false, length = 15))
    private Status status;

    @Override
    public PropertiesImpl getProperty() {
        return property;
    }

    @Override
    public void setProperty(Properties property) {
        this.property = (PropertiesImpl) property;
    }
}