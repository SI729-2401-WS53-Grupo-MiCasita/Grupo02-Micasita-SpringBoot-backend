package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.UpdateBuyResource;

public class UpdateBuyCommandFromResourceAssembler {
    public static UpdateBuyCommand toCommandFromResource(Long buyId, UpdateBuyResource resource) {
        return new UpdateBuyCommand(
                buyId,
                resource.userID(),
                resource.dateTime(),
                resource.amount(),
                resource.status(),
                resource.properties()
        );
    }
}