package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import jakarta.persistence.Embedded;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.ControllerId;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.PublicationId;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.UserId;

public class Notifications {
    @Embedded
    private ControllerId controllerId;
    @Embedded
    private UserId userId;
    @Embedded
    private PublicationId publicationId;
}
