package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate.Events;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateTransactionEventsCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateTransactionEventsCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.*;

import java.time.LocalDateTime;

@Getter
@Setter
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

    public TransactionEvents() {
    }

    public TransactionEvents(TransactionID transactionID, LocalDateTime EventDate, Buy buy, Rent rent, Events events) {
        this.transactionID = transactionID;
        this.EventDate = EventDate;
        this.buy = buy;
        this.rent = rent;
        this.events = events;
    }

    public TransactionEvents(CreateTransactionEventsCommand command) {
        this.transactionID = command.transactionID();
        this.EventDate = command.EventDate();
        this.buy = command.buy();
        this.rent = command.rent();
        this.events = command.events();
    }

    public void updateTransactionEvents(UpdateTransactionEventsCommand command) {
        this.transactionID = command.transactionID();
        this.EventDate = command.EventDate();
        this.buy = command.buy();
        this.rent = command.rent();
        this.events = command.events();
    }
}
