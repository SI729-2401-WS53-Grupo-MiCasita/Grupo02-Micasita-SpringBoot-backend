package pe.edu.upc.micasita.Micasitaplataform.interaction.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Notification;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetAllNotificationsFromUserQuery;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetUnreadNotificationsFromUserQuery;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services.NotificationQueryService;
import pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories.NotificationRepository;

import java.util.List;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {
    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public List<Notification> handle(GetAllNotificationsFromUserQuery query) {
        return notificationRepository.findByUserId(query.userId().userID());
    }

    @Override
    public List<Notification> handle(GetUnreadNotificationsFromUserQuery query) {
        return notificationRepository.findByUserIdAndReadFalse(query.userId().userID());
    }
}
