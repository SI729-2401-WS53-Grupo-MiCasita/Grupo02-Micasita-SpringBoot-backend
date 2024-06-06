package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.DeletePropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.DeletePropertyResource;

public class DeletePropertyCommandFromResourceAssembler {
    public static DeletePropertyCommand toCommandFromResource(DeletePropertyResource resource) {
        return new DeletePropertyCommand(resource.id());
    }
}