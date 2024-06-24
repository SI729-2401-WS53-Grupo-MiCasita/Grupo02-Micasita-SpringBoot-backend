package pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "vouchers")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoucher;

    @OneToMany(mappedBy = "voucher")
    private List<Buy> buys;

    @OneToMany(mappedBy = "voucher")
    private List<Rent> rents;

    @Column(name = "buy_amount")
    private Double buyAmount;

    @Column(name = "rent_amount")
    private Double rentAmount;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Voucher() {}

    public Voucher(Double buyAmount, Double rentAmount) {
        this.buyAmount = buyAmount;
        this.rentAmount = rentAmount;
    }
}