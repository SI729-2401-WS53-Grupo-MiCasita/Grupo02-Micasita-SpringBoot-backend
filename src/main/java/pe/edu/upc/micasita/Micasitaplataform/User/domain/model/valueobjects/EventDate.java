package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public record EventDate(LocalDateTime value) {
    public EventDate {
        if (value == null) {
            throw new IllegalArgumentException("EventDate cannot be null");
        }
    }
}