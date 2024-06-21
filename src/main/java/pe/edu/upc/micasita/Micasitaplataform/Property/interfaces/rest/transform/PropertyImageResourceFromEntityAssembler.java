package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Property;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.entities.PropertyImage;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.PropertyImageResource;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.PropertyResource;

public class PropertyImageResourceFromEntityAssembler {
    public static PropertyImageResource toResourceFromEntity(PropertyImage entity) {
        return new PropertyImageResource(
                entity.getId(),
                entity.getUrl(),
                entity.getPropertyId()
        );
    }
}
