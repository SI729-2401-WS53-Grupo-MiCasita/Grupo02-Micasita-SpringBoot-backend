package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.AddPropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.CreatePropertyResource;

public class CreatePropertyCommandFromResourceAssembler {
    public static AddPropertyCommand toCommandFromResource(CreatePropertyResource resource) {
        Properties property = new Properties();
        property.setTitle(resource.propertyName());
        property.setType(resource.propertyType());
        property.setLocation(resource.propertyLocation());
        property.setPrice(resource.propertyPrice());
        return new AddPropertyCommand(property);
    }
}