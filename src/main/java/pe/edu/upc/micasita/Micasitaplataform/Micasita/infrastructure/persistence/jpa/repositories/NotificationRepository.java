package pe.edu.upc.micasita.Micasitaplataform.Micasita.infrastructure.persistence.jpa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Notifications;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {
}
