package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.TransactionEventResource;

public class TransactionEventResourceFromEntityAssembler {

    public static TransactionEventResource toResourceFromEntity(TransactionEvents entity) {
        return new TransactionEventResource(entity.getId(), entity.getTransactionID(), entity.getEventDate(), entity.getBuy(), entity.getRent(), entity.getEvents());
    }
}