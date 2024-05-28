package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.EventDate;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Status;

@Entity
@Table(name = "transaction_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "event_date", nullable = false))
    private EventDate eventDate;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "buy_id")
    private Buy buy;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "status", nullable = false, length = 15))
    private Status status;
}
