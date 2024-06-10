package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.BuyResource;

public class BuyResourceFromEntityAssembler {

    public static BuyResource toResourceFromEntity(Buy entity) {
        return new BuyResource(entity.getId(), entity.getUserID(), entity.getDateTime(), entity.getAmount(), entity.getStatus(), entity.getProperties());
    }
}