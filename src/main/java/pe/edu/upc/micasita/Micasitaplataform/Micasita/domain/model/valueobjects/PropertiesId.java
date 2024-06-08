package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

public record PropertiesId(Long propertiesId) {
    public static final Object value = 0;

    public PropertiesId() {
        this(0L);
    }

    public PropertiesId {
        if (propertiesId < 0) {
            throw new IllegalArgumentException("PropertiesId cannot be negative");
        }
    }
}