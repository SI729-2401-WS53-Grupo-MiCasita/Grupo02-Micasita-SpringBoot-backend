package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

public record UserId(Long userId) {
    public UserId() {
        this(0L);
    }
    public UserId {
        if (userId < 0) {
            throw new IllegalArgumentException("UserId cannot be negative");
        }
    }
}
