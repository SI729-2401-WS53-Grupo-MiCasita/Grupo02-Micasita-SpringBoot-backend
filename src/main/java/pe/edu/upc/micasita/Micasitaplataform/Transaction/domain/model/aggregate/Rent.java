package pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.CreateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.UpdateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.valueobjects.UserInfo;
import pe.edu.upc.micasita.Micasitaplataform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Rent  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRent;

    @Embedded
    private UserInfo userInfo;

    @Column(name = "id_property")
    private Long idProperty;

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
    public Rent() {}
    public Rent(String name, String dni, String phoneNumber, String email) {
        this.userInfo = new UserInfo(name, dni, phoneNumber, email);}

    public Rent(CreateRentCommand command) {
        this.userInfo = new UserInfo(command.name(), command.dni(), command.phoneNumber(), command.email());
        this.idProperty = command.idProperty();
        this.rentAmount = command.rentAmount();
    }
    public void update(UpdateRentCommand command) {
        this.userInfo = new UserInfo(command.name(), command.dni(), command.phoneNumber(), command.email());
    }
}