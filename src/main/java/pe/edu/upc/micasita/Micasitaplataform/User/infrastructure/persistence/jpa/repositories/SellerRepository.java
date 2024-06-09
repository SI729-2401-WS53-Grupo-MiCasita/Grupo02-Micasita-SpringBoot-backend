package pe.edu.upc.micasita.Micasitaplataform.User.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.aggregates.Sellers;

public interface SellerRepository extends JpaRepository<Sellers, Integer> {
}
