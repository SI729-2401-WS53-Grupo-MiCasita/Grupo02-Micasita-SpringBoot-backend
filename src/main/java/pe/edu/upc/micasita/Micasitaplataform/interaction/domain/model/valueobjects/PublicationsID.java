package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record PublicationsID(Long publicationID){
    public PublicationsID() {
        this(0L);
    }
    public PublicationsID {
        if(publicationID < 0){
            throw new IllegalArgumentException("Profile publicationID cannot be negative");
        }
    }
}
