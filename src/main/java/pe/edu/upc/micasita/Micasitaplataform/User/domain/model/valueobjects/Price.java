package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
@Embeddable
public record Price(BigDecimal value) {
    public Price {
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}