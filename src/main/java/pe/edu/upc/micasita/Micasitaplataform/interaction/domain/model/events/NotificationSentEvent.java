package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

public class NotificationSentEvent {
    private Integer notificationId;
    private Integer userId;
    private String message;

    public NotificationSentEvent(Integer notificationId, Integer userId, String message) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
