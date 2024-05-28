package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public record DateTime(LocalDateTime value) {
    public DateTime {
        if (value == null) {
            throw new IllegalArgumentException("DateTime cannot be null");
        }
    }
}
