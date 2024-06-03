package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record TransactionEventsID(Long transactionEventsID){
    public TransactionEventsID() {
        this(0L);
    }
    public TransactionEventsID{
        if(transactionEventsID < 0){
            throw new IllegalArgumentException("Profile transactionEventsID cannot be negative");
        }
    }
}
