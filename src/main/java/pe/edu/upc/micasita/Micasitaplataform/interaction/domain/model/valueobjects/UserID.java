package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserID(Long userID) {
    public UserID() {
        this(0L);
    }
    public UserID{
        if(userID < 0){
            throw new IllegalArgumentException("Profile userId cannot be negative");
        }
    }
}
