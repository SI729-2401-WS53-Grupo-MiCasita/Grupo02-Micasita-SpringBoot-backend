package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities;

import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Address;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.DNI;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Email;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Phone;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Notification;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email", nullable = false, unique = true, length = 50))
    private Email email;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "phone", nullable = false, unique = true, length = 15))
    private Phone phone;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "dni", nullable = false, unique = true, length = 15))
    private DNI dni;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "address", nullable = false, length = 50))
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentMethod> paymentMethods;
}