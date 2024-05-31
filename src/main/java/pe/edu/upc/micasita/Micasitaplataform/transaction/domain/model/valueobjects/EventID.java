package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EventID(Long eventId) {
    public EventID() {
        this(0L);
    }
    public EventID {
        if (eventId < 0) {
            throw new IllegalArgumentException("Profile eventId cannot be negative");
        }
    }
}
