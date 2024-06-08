package pe.edu.upc.micasita.Micasitaplataform.interaction.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.CreateNotificationCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.DeleteNotificationCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Notification;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services.NotificationCommandService;
import pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories.NotificationRepository;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {

    private final NotificationRepository notificationRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Integer handle(CreateNotificationCommand command) {
        var notification = new Notification();
        try {
            notificationRepository.save(notification);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al crear la notificación");
        }
        return notification.getId();
    }

    @Override
    public void handle(DeleteNotificationCommand command) {
        var notificationId = command.NotificationId();
        try {
            notificationRepository.deleteById(notificationId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al eliminar la notificación");
        }
    }
}
