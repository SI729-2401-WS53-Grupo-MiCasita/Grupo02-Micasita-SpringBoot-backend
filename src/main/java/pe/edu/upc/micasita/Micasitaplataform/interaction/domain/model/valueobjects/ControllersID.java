package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record ControllersID(Long controllersID) {
    public ControllersID() {
        this(0L);
    }
    public ControllersID{
        if(controllersID < 0){
            throw new IllegalArgumentException("Profile publicationID cannot be negative");
        }
    }
}
