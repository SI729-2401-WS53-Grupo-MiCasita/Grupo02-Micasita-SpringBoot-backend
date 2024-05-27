package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.NotificationRepository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.Notification;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Integer id) {
        return notificationRepository.findById(id);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Integer id, Notification notificationDetails) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    notification.setMessage(notificationDetails.getMessage());
                    notification.setStatus(notificationDetails.getStatus());
                    notification.setUser(notificationDetails.getUser());
                    return notificationRepository.save(notification);
                })
                .orElseGet(() -> {
                    notificationDetails.setId(id);
                    return notificationRepository.save(notificationDetails);
                });
    }

    public void deleteNotification(Integer id) {
        notificationRepository.deleteById(id);
    }
}