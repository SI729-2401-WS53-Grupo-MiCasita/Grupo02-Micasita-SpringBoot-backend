package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource;

import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate.Events;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.TransactionID;

import java.time.LocalDateTime;

public record UpdateTransactionEventResource(TransactionID transactionID, LocalDateTime EventDate, Buy buy, Rent rent, Events events) {
}