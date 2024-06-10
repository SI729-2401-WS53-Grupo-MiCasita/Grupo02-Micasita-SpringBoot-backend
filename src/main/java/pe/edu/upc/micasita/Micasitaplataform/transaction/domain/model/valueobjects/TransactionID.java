package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record TransactionID(Long transactionId){
    public TransactionID() {
        this(0L);
    }
    public TransactionID {
        if (transactionId < 0) {
            throw new IllegalArgumentException("Profile transactionID cannot be negative");
        }
    }
}
