package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.UpdatePropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.UpdatePropertyResource;

public class UpdatePropertyCommandFromResourceAssembler {
    public static UpdatePropertyCommand toCommandFromResource(UpdatePropertyResource resource) {
        Properties propertyDetails = new Properties();
        propertyDetails.setTitle(resource.propertyName());
        propertyDetails.setType(resource.propertyType());
        propertyDetails.setLocation(resource.propertyLocation());
        propertyDetails.setPrice(resource.propertyPrice());
        return new UpdatePropertyCommand(resource.id(), propertyDetails);
    }
}