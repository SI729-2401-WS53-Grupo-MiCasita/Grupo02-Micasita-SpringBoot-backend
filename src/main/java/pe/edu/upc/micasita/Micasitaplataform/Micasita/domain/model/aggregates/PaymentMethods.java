package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.ControllerId;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.UserId;

public class PaymentMethods {
    @Embedded
    private ControllerId controllerId;

    @Embedded
    private UserId userId;

}
