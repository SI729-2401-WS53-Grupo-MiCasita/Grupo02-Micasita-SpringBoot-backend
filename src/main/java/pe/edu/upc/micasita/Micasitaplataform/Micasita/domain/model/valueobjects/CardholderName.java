package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class CardholderName {
    String value;

    protected CardholderName() {
        this.value = "";
    }

    public CardholderName(String value) {
        if (value == null || value.isEmpty() || value.length() > 50) {
            throw new IllegalArgumentException("Invalid cardholder name format");
        }
        this.value = value;
    }
}