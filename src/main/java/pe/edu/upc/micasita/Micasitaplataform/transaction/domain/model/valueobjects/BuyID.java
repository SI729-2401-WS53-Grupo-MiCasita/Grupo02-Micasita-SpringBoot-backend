package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BuyID(Long buyId) {
    public BuyID() {
        this(0L);
    }
    public BuyID {
        if (buyId < 0) {
            throw new IllegalArgumentException("Profile buyId cannot be negative");
        }
    }
}
