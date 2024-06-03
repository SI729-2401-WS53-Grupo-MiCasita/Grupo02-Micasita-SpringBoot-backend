package pe.edu.upc.micasita.Micasitaplataform.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;

@Repository
public interface TransactionEventsRepository extends JpaRepository<TransactionEvents, Long> {
}