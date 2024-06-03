package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ControllerId (Long controllerId) {
    public ControllerId() {
        this(0L);
    }
    public ControllerId {
        if (controllerId < 0) {
            throw new IllegalArgumentException("ControllerId cannot be negative");
        }
    }
}
