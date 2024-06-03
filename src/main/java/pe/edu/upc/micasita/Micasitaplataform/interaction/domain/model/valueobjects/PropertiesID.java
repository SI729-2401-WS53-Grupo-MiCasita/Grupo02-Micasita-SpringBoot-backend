package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PropertiesID(Long propertiesID) {
    public PropertiesID() {
        this(0L);
    }
    public PropertiesID{
        if(propertiesID < 0){
            throw new IllegalArgumentException("Profile propertiesID cannot be negative");
        }
    }
}
