package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.DateTime;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private TransactionID transactionID;

    @Embedded
    private EventID eventID;

    private DateTime EventDate;

    @Embedded
    private BuyID buyID;
    @Embedded
    private RentID rentID;

}
