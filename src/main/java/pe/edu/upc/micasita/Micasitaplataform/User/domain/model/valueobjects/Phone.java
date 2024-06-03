package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;


public record Phone(String value) {
    private static final String PHONE_REGEX = "\\d{10,15}";

    public Phone {
        if (value == null || !value.matches(PHONE_REGEX)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
