package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Buy;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Amount;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.DateTime;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Status;

@Entity
@Table(name = "buys")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyImpl implements Buy {
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
    @AttributeOverride(name = "value", column = @Column(name = "date_time", nullable = false))
    private DateTime dateTime;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "amount", nullable = false, precision = 15, scale = 2))
    private Amount amount;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "status", nullable = false, length = 15))
    private Status status;
}