package pe.edu.upc.micasita.Micasitaplataform.Micasita.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.PaymentMethods;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethods, Integer> {
}

