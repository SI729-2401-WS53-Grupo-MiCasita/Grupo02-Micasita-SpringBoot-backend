package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Favorites;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Notifications;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.infrastructure.persistence.jpa.repositories.NotificationRepository;

import java.util.List;

public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notifications> findAll() {
        return notificationRepository.findAll();
    }

    public Notifications save(Notifications notifications) {
        return notificationRepository.save(notifications);
    }

    public void deleteById(Integer id) {
        notificationRepository.deleteById(id);
    }
}
