package pe.edu.upc.micasita.Micasitaplataform.transaction.application.internal.QueryServices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetAllTransactionEventsQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetTransactionEventByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetTransactionEventDateTimeBetweenQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.TransactionEventQueryService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories.TransactionEventsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionEventQueryServiceImpl implements TransactionEventQueryService {

    private final TransactionEventsRepository transactionEventsRepository;

    public TransactionEventQueryServiceImpl(TransactionEventsRepository transactionEventsRepository) {
        this.transactionEventsRepository = transactionEventsRepository;
    }

    @Override
    public Optional<TransactionEvents> handle(GetTransactionEventByIdQuery query) {
        return transactionEventsRepository.findByTransactionID(query.transactionID());
    }

    @Override
    public List<TransactionEvents> handle(GetAllTransactionEventsQuery query) {
        return transactionEventsRepository.findAll();
    }

    @Override
    public List<TransactionEvents> handle(GetTransactionEventDateTimeBetweenQuery query) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}