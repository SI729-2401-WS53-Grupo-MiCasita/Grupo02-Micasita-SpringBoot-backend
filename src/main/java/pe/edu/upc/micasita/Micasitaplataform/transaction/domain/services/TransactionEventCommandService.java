package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateTransactionEventsCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteTransactionEventCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateTransactionEventsCommand;

import java.util.Optional;

public interface TransactionEventCommandService {
    Long handle(CreateTransactionEventsCommand command);
    Optional<TransactionEvents> handle(UpdateTransactionEventsCommand command);
    void handle(DeleteTransactionEventCommand command);
}
