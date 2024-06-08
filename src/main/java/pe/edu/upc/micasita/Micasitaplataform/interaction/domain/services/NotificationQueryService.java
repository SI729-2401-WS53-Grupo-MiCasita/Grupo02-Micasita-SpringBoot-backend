package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Notification;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetAllNotificationsFromUserQuery;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetUnreadNotificationsFromUserQuery;

import java.util.List;

public interface NotificationQueryService {
    List<Notification> handle(GetAllNotificationsFromUserQuery query);
    List<Notification> handle(GetUnreadNotificationsFromUserQuery query);
}
