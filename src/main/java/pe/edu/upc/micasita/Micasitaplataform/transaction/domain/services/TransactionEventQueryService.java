package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetAllTransactionEventsQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetTransactionEventByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetTransactionEventDateTimeBetweenQuery;

import java.util.List;
import java.util.Optional;

public interface TransactionEventQueryService {
    List<TransactionEvents> handle(GetAllTransactionEventsQuery query);
    Optional<TransactionEvents> handle(GetTransactionEventByIdQuery query);
    List<TransactionEvents> handle(GetTransactionEventDateTimeBetweenQuery query);
}
