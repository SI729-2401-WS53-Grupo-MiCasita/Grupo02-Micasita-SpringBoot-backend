package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;


public record Address(String value) {
    public Address {
        if (value == null || value.isEmpty() || value.length() > 50) {
            throw new IllegalArgumentException("Invalid address format");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}