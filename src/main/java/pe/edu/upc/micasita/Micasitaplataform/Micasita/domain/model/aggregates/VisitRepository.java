package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
  
}
