package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class NotificationMessage {
    private String value;

    protected NotificationMessage() {
        this.value = "";
    }

    public NotificationMessage(String value) {
        if (value == null || value.isEmpty() || value.length() > 255) {
            throw new IllegalArgumentException("Invalid notification message format");
        }
        this.value = value;
    }
}