package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.AddPropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.CreatePropertyResource;

public class CreatePropertyCommandFromResourceAssembler {
    public static AddPropertyCommand toCommandFromResource(CreatePropertyResource resource) {
        Properties property = new Properties();
        property.setTitle(resource.title());
        property.setDescription(resource.description());
        property.setPrice(resource.price());
        property.setLocation(resource.location());
        property.setStatus(resource.status());
        property.setType(resource.type());
        property.setSize(resource.size());
        property.setBedrooms(resource.bedrooms());
        property.setBathrooms(resource.bathrooms());
        property.setGarageSpace(resource.garageSpace());
        property.setYearBuilt(resource.yearBuilt());
        return new AddPropertyCommand(property);
    }
}