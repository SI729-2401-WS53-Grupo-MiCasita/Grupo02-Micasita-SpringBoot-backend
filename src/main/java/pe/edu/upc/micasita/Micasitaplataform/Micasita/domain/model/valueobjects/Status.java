package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;



public record Status(String value) {
    public Status {
        if (value == null || (!value.equalsIgnoreCase("sale") && !value.equalsIgnoreCase("rent"))) {
            throw new IllegalArgumentException("Status must be either 'sale' or 'rent'");
        }
    }
}