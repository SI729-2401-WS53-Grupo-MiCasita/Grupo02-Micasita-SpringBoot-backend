package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.CreateRentResource;

public class CreateRentCommandFromResourceAssembler {

    public static CreateRentCommand toCommandFromResource(CreateRentResource resource) {
        return new CreateRentCommand(resource.userID(), resource.dateTime(), resource.status(), resource.properties());
    }
}