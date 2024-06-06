package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationSentEvent {
    private Integer notificationId;
    private Integer userId;
    private String message;

    public NotificationSentEvent(Integer notificationId, Integer userId, String message) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
    }

}
