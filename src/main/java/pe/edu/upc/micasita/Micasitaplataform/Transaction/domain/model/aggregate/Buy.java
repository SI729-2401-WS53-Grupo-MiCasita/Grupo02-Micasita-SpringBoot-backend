package pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.CreateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.UpdateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.UpdateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.valueobjects.UserInfo;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "buys")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBuy;

    @Embedded
    private UserInfo userInfo;

    @Column(name = "id_property", nullable = false)
    private Long idProperty;

    @Column(name = "buy_amount", nullable = false)
    private Double buyAmount;

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

    public Buy() {}

    public Buy(String name, String dni, String phoneNumber, String email) {
        this.userInfo = new UserInfo(name, dni, phoneNumber, email);
    }

    public Buy(CreateBuyCommand command) {
        this.userInfo = new UserInfo(command.name(), command.dni(), command.phoneNumber(), command.email());
        this.idProperty = command.idProperty();
        this.buyAmount = command.buyAmount();
    }
    public void update(UpdateBuyCommand command) {
        this.userInfo = new UserInfo(command.name(), command.dni(), command.phoneNumber(), command.email());
    }
}
