package pe.edu.upc.micasita.Micasitaplataform.Property.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;

public interface PropertyRepository extends JpaRepository<Properties, Integer> {
}
