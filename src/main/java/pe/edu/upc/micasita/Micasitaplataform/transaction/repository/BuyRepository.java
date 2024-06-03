package pe.edu.upc.micasita.Micasitaplataform.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

}
