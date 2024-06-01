package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;


import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.PropertyID;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserID userID;

    @Embedded
    private PropertyID propertyID;

    private LocalDateTime dateTime;

    private BigDecimal amount;

    private String status;

    private Long usersId;

    @OneToMany(mappedBy = "buy")
    private List<TransactionEvents> transactionEvents;
}
