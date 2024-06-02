package pe.edu.upc.micasita.Micasitaplataform.controllers.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record VisitsID(Long visitsID) {
    public VisitsID() {
        this(0L);
    }
    public VisitsID{
        if(visitsID < 0){
            throw new IllegalArgumentException("Profile visitsID cannot be negative");
        }
    }
}
