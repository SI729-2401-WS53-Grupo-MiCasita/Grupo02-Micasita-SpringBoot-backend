package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserID(Long userId) {
    public UserID() {
        this(0L);
    }
    public UserID{
        if(userId < 0){
            throw new IllegalArgumentException("Profile userId cannot be negative");
        }
    }
}
