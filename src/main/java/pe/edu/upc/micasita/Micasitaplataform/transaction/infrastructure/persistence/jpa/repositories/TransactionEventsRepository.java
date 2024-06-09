package pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.TransactionID;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionEventsRepository extends JpaRepository<TransactionEvents, Long> {
    Optional<TransactionEvents> findByTransactionID(TransactionID transactionID);
    boolean existsByTransactionID(TransactionID transactionID);
    boolean existsByTransactionIDAndIdIsNot(TransactionID transactionID, Long id);
    List<TransactionEvents> findByBuy(Buy buy);
    List<TransactionEvents> findByRent(Rent rent);
}