package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.TransactionEvents;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.DateTime;

@Entity
@Table(name = "transaction_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEventsImpl implements TransactionEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transaction_id", nullable = false)
    private Integer transactionId;

    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "event_date", nullable = false))
    private DateTime eventDate;

    @Column(name = "rent_id")
    private Integer rentId;
}
