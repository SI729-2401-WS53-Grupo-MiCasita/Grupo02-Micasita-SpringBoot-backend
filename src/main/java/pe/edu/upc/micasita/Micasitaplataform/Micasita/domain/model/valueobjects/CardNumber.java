package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
public class CardNumber {
    String value;

    private static final String CARD_NUMBER_REGEX = "\\d{16}";

    protected CardNumber() {
        this.value = "";
    }

    public CardNumber(String value) {
        if (value == null || !value.matches(CARD_NUMBER_REGEX)) {
            throw new IllegalArgumentException("Invalid card number format");
        }
        this.value = value;
    }
}