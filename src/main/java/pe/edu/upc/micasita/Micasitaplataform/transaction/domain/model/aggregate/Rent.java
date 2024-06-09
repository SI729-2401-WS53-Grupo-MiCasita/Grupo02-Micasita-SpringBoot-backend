package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserID userID;

    private LocalDateTime dateTime;

    private String status;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

    public Rent() {
    }

    public Rent(UserID userID, LocalDateTime dateTime, String status, Properties properties) {
        this.userID = userID;
        this.dateTime = dateTime;
        this.status = status;
        this.properties = properties;
    }

    public Rent(CreateRentCommand command) {
        this.userID = command.userID();
        this.dateTime = command.dateTime();
        this.status = command.status();
        this.properties = command.properties();
    }

    public void updateRent(UpdateRentCommand command) {
        this.userID = command.userID();
        this.dateTime = command.dateTime();
        this.status = command.status();
        this.properties = command.properties();
    }
}
