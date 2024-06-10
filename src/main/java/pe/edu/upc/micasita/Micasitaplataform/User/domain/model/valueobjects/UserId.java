package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId(Long userId) {
    public UserId {
        if (userId < 0) {
            throw new IllegalArgumentException("PropertyId cannot be negative");
        }
    }

    public UserId() {
        this(0L);
    }
}
