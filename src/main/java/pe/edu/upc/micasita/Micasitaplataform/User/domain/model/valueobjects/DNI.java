package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;


public record DNI(String value) {
    private static final String DNI_REGEX = "\\d{8,15}";

    public DNI {
        if (value == null || !value.matches(DNI_REGEX)) {
            throw new IllegalArgumentException("Invalid DNI format");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}