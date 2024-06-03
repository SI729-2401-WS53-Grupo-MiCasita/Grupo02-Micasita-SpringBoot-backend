package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate.Events;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.*;

import java.time.LocalDateTime;


@Entity
public class TransactionEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private TransactionID transactionID;

    private LocalDateTime EventDate;


    @ManyToOne
    @JoinColumn(name = "buy_id")
    private Buy buy;


    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events events;

}
