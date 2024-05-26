package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Value;

@Value
@Embeddable
public class BillingAddress {
    String value;

    public BillingAddress(String value) {
        if (value == null || value.isEmpty() || value.length() > 100) {
            throw new IllegalArgumentException("Invalid billing address format");
        }
        this.value = value;
    }

    public BillingAddress() {
        this.value = "";
    }

    @Override
    public String toString() {
        return value;
    }
}