package pe.edu.upc.micasita.Micasitaplataform.User.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.aggregates.Sellers;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface SellerQueryService {
    Optional<Sellers> handle(GetSellerByIdQuery query);
}
