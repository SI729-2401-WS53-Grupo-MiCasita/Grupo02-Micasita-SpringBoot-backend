package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;

import jakarta.persistence.Embeddable;


@Embeddable
public record Amount(Long value) {
    public Amount {
        if (value <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}
