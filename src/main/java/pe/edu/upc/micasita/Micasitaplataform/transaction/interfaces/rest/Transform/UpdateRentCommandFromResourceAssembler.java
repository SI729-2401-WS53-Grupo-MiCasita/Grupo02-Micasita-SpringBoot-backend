package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.UpdateRentResource;

public class UpdateRentCommandFromResourceAssembler {
    public static UpdateRentCommand toCommandFromResource(Long rentId, UpdateRentResource resource) {
        return new UpdateRentCommand(
                rentId,
                resource.userID(),
                resource.dateTime(),
                resource.status(),
                resource.properties()
        );
    }
}