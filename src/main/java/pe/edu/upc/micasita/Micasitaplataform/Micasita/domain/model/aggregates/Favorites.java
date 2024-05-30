package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import jakarta.persistence.Embedded;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.PropertiesId;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.UserId;

public class Favorites {

    @Embedded
    private UserId userId;

    @Embedded
    private PropertiesId propertiesId;
}
