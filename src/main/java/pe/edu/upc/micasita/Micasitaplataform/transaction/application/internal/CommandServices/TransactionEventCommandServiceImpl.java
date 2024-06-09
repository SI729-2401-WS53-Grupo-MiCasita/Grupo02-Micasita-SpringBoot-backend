package pe.edu.upc.micasita.Micasitaplataform.transaction.application.internal.CommandServices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateTransactionEventsCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteTransactionEventCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateTransactionEventsCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.TransactionEventCommandService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories.TransactionEventsRepository;

import java.util.Optional;

@Service
public class TransactionEventCommandServiceImpl implements TransactionEventCommandService {

    private final TransactionEventsRepository transactionEventsRepository;

    public TransactionEventCommandServiceImpl(TransactionEventsRepository transactionEventsRepository) {
        this.transactionEventsRepository = transactionEventsRepository;
    }

    @Override
    public Long handle(CreateTransactionEventsCommand command) {
        if (transactionEventsRepository.existsByTransactionID(command.transactionID())) {
            throw new IllegalArgumentException("TransactionEvent with same transaction ID already exists");
        }
        var transactionEvent = new TransactionEvents(command);
        try {
            transactionEventsRepository.save(transactionEvent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving transactionEvent: " + e.getMessage());
        }
        return transactionEvent.getId();
    }

    @Override
    public Optional<TransactionEvents> handle(UpdateTransactionEventsCommand command) {
        if (transactionEventsRepository.existsByTransactionIDAndIdIsNot(command.transactionID(), command.id()))
            throw new IllegalArgumentException("TransactionEvent with same transaction ID already exists");
        var result = transactionEventsRepository.findById(command.id());
        if (result.isEmpty())
            throw new IllegalArgumentException("TransactionEvent does not exist");
        var transactionEventToUpdate = result.get();
        try {
            transactionEventToUpdate.updateTransactionEvents(command);
            var updatedTransactionEvent = transactionEventsRepository.save(transactionEventToUpdate);
            return Optional.of(updatedTransactionEvent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating transactionEvent: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteTransactionEventCommand command) {
        if (!transactionEventsRepository.existsById(command.id())) {
            throw new IllegalArgumentException("TransactionEvent does not exist");
        }
        try {
            transactionEventsRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting transactionEvent: " + e.getMessage());
        }
    }
}