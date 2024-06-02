package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.controllers.domain.model.entities.Controllers;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class TransactionEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private TransactionID transactionID;

    @Embedded
    private EventID eventID;

    private LocalDateTime EventDate;

    @Embedded
    private BuyID buyID;
    @Embedded
    private RentID rentID;

}
