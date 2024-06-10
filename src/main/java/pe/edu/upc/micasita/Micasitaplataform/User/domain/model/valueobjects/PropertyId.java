package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PropertyId (Long propertyId){

    public PropertyId {
        if (propertyId < 0) {
            throw new IllegalArgumentException("PropertyId cannot be negative");
        }
    }

    public PropertyId() {
        this(0L);
    }
}
