package pe.edu.upc.micasita.Micasitaplataform.User.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.aggregates.Sellers;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries.*;

import java.util.List;

public interface SellerQueryService {
    List<Sellers> handle(GetAllSellersQuery query);
    Sellers handle(GetSellerByIdQuery query);
    Sellers handle(CreateSellerQuery query);
    Sellers handle(UpdateSellerQuery query);
    void handle(DeleteSellerQuery query);
}
