package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import java.math.BigDecimal;


public record Price(BigDecimal value) {
    public Price {
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}