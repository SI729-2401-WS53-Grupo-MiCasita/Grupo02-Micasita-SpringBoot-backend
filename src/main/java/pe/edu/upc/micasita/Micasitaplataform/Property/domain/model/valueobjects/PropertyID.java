package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PropertyID(Long propertyID) {
    public PropertyID() {
        this(0L);
    }

    public PropertyID {
        if (propertyID < 0) {
            throw new IllegalArgumentException("Profile PropertyId cannot be negative");
        }
    }
}
