package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public record Amount(BigDecimal value) {
    public Amount {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
