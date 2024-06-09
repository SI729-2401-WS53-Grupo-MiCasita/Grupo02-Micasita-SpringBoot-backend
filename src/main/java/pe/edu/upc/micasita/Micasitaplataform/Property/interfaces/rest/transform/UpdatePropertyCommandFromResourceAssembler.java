package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.UpdatePropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.UpdatePropertyResource;

public class UpdatePropertyCommandFromResourceAssembler {
    public static UpdatePropertyCommand toCommandFromResource(UpdatePropertyResource resource) {
        Properties propertyDetails = new Properties();
        propertyDetails.setTitle(resource.title());
        propertyDetails.setDescription(resource.description());
        propertyDetails.setPrice(resource.price());
        propertyDetails.setLocation(resource.location());
        propertyDetails.setStatus(resource.status());
        propertyDetails.setType(resource.type());
        propertyDetails.setSize(resource.size());
        propertyDetails.setBedrooms(resource.bedrooms());
        propertyDetails.setBathrooms(resource.bathrooms());
        propertyDetails.setGarageSpace(resource.garageSpace());
        propertyDetails.setYearBuilt(resource.yearBuilt());
        return new UpdatePropertyCommand(resource.Id(), propertyDetails);
    }
}