package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetAllRentsQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetRentByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetRentDateTimeBetweenQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetRentStatusQuery;

import java.util.List;
import java.util.Optional;

public interface RentQueryService {
    List<Rent> handle(GetAllRentsQuery query);
    Optional<Rent> handle(GetRentByIdQuery query);
    List<Rent> handle(GetRentDateTimeBetweenQuery query);
    List<Rent> handle(GetRentStatusQuery query);
}