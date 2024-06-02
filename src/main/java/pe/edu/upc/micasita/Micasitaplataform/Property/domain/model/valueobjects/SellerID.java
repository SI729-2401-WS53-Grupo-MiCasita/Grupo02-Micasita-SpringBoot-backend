package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record SellerID(Long sellerID) {
    public SellerID() {
        this(0L);
    }

    public SellerID {
        if (sellerID < 0) {
            throw new IllegalArgumentException("Profile SellerId cannot be negative");
        }
    }
}