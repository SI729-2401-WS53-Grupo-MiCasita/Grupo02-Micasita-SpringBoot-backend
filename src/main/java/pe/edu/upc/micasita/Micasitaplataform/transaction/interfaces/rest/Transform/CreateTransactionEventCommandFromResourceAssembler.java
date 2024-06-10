package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;


import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateTransactionEventsCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.CreateTransactionEventResource;

public class CreateTransactionEventCommandFromResourceAssembler {

    public static CreateTransactionEventsCommand toCommandFromResource(CreateTransactionEventResource resource) {
        return new CreateTransactionEventsCommand(resource.transactionID(), resource.EventDate(), resource.buy(), resource.rent(), resource.events());
    }
}