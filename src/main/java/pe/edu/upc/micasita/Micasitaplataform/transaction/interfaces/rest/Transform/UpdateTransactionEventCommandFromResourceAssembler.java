package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateTransactionEventsCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.UpdateTransactionEventResource;

public class UpdateTransactionEventCommandFromResourceAssembler {
    public static UpdateTransactionEventsCommand toCommandFromResource(Long transactionEventId, UpdateTransactionEventResource resource) {
        return new UpdateTransactionEventsCommand(
                transactionEventId,
                resource.transactionID(),
                resource.EventDate(),
                resource.buy(),
                resource.rent(),
                resource.events()
        );
    }
}