package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RentID(Long rentId) {
    public RentID() {
        this(0L); // Valor
    }
    public RentID {
        if (rentId < 0) {
            throw new IllegalArgumentException("Profile rentId cannot be negative");
        }
    }
}
