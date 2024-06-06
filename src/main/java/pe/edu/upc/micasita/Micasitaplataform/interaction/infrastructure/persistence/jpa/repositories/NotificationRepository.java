package pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Notification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByUser(User user);

    List<Notification> findByUserId(Integer user_id);

    @Query("SELECT n FROM Notification n WHERE n.user.id = :userId AND n.status = 'UNREAD'")
    List<Notification> findUnreadNotificationsByUserId(@Param("userId") Long userId);
}
