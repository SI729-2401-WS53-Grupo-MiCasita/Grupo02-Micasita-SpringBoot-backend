package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.RentResource;

public class RentResourceFromEntityAssembler {

    public static RentResource toResourceFromEntity(Rent entity) {
        return new RentResource(entity.getId(), entity.getUserID(), entity.getDateTime(), entity.getStatus(), entity.getProperties());
    }
}