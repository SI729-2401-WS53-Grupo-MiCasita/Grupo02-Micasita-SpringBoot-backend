package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationReadEvent {
    private Integer notificationId;
    private Integer userId;

    public NotificationReadEvent(Integer notificationId, Integer userId) {
        this.notificationId = notificationId;
        this.userId = userId;
    }

}
