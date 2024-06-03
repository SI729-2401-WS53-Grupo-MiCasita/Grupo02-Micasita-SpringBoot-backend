package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetAllBuysQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetBuyByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetBuyDateTimeBetweenQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetBuyStatusQuery;

public interface BuyQueryService {
    List<Buy> handle(GetAllBuysQuery query);
    Optional<Buy> handle(GetBuyByIdQuery query);
    List<Buy> handle(GetBuyDateTimeBetweenQuery query);
    List<Buy> handle(GetBuyStatusQuery query);
}
