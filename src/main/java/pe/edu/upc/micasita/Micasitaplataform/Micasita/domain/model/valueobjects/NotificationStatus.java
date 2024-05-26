package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class NotificationStatus {
    private String value;

    protected NotificationStatus() {
        this.value = "";
    }

    public NotificationStatus(String value) {
        if (value == null || value.isEmpty() || value.length() > 15) {
            throw new IllegalArgumentException("Invalid notification status format");
        }
        this.value = value;
    }
}