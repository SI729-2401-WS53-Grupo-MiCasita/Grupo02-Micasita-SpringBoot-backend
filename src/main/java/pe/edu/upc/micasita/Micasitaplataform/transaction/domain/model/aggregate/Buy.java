package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserID userID;

    private LocalDateTime dateTime;

    private Long amount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

    public Buy() {
    }

    public Buy(UserID userID, LocalDateTime dateTime, Long amount, String status, Properties properties) {
        this.userID = userID;
        this.dateTime = dateTime;
        this.amount = amount;
        this.status = status;
        this.properties = properties;
    }

    public Buy(CreateBuyCommand command) {
        this.userID = command.userID();
        this.dateTime = command.dateTime();
        this.amount = command.amount();
        this.status = command.status();
        this.properties = command.properties();
    }

    public void updateBuy(UpdateBuyCommand command) {
        this.userID = command.userID();
        this.dateTime = command.dateTime();
        this.amount = command.amount();
        this.status = command.status();
        this.properties = command.properties();
    }
}
