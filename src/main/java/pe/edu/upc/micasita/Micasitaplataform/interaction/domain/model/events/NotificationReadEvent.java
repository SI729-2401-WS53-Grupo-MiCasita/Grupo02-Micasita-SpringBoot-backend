package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

public class NotificationReadEvent {
    private Integer notificationId;
    private Integer userId;

    public NotificationReadEvent(Integer notificationId, Integer userId) {
        this.notificationId = notificationId;
        this.userId = userId;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
