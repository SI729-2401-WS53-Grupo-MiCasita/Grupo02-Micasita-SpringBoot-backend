package pe.edu.upc.micasita.Micasitaplataform.controllers.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EventsID(Long eventId) {
    public EventsID() {
        this(0L);
    }
    public EventsID {
        if (eventId < 0) {
            throw new IllegalArgumentException("Profile eventId cannot be negative");
        }
    }
}
