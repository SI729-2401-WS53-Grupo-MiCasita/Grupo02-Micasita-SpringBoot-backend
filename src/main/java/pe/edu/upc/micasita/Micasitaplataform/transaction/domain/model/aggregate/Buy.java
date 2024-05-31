package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate;


import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.PropertyID;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

}
