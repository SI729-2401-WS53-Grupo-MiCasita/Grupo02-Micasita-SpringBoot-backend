package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.PropertyResource;

public class PropertyResourceFromEntityAssembler {
    public static PropertyResource toResourceFromEntity(Properties entity) {
        return new PropertyResource(entity.getId(), entity.getTitle(), entity.getType(), entity.getLocation(), entity.getPrice());
    }
}