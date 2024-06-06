package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities;

import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.CreateUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.DeleteUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.UpdateUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Address;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.DNI;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Email;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Phone;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Notification;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;

import java.util.List;


@Table(name = "users")
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.email = command.email();
        this.password = command.password();
        this.phone = command.phone();
        this.dni = command.dni();
        this.address = command.address();
    }

    public User(UpdateUserCommand command) {
        this.name = command.name();
        this.email = command.email();
        this.password = command.password();
        this.phone = command.phone();
        this.dni = command.dni();
        this.address = command.address();
    }

    public User(DeleteUserCommand command) {
        this.id = command.id();
    }

}