package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.CreateBuyResource;

public class CreateBuyCommandFromResourceAssembler {

    public static CreateBuyCommand toCommandFromResource(CreateBuyResource resource) {
        return new CreateBuyCommand(resource.userID(), resource.dateTime(), resource.amount(), resource.status(), resource.properties());
    }
}