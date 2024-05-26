package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}