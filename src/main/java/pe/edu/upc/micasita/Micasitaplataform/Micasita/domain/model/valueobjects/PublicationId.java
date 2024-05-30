package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

public record PublicationId(Long publicationId) {
    public PublicationId() {
        this(0L);
    }

    public PublicationId {
        if (publicationId < 0) {
            throw new IllegalArgumentException("PublicationId cannot be negative");
        }
    }
}