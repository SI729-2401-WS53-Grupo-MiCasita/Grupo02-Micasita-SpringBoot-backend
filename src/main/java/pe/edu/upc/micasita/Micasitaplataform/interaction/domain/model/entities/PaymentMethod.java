package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.BillingAddress;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.CardNumber;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.CardholderName;
import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.controllers.domain.model.entities.Controllers;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.ControllerId;

import java.time.LocalDate;

@Entity
@Table(name = "payment_methods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "controller_id", nullable = false)
    private Controllers controllers;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "card_number", nullable = false, length = 20))
    private CardNumber cardNumber;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "cardholder_name", nullable = false, length = 50))
    private CardholderName cardholderName;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "billing_address", nullable = false, length = 100))
    private BillingAddress billingAddress;
}