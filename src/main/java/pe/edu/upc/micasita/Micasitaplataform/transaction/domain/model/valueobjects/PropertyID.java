package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PropertyID(Long propertyId) {
    public PropertyID() {
        this(0L);
    }
    public PropertyID {
        if(propertyId < 0){
            throw new IllegalArgumentException("Profile propertyId cannot be negative");
        }
    }
}
