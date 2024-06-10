package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects;



public class Price {

    public Price(Long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }

}