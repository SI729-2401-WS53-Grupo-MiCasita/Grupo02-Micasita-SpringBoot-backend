package pe.edu.upc.micasita.Micasitaplataform.transaction.application.internal.QueryServices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetAllRentsQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetRentByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetRentDateTimeBetweenQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetRentStatusQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.RentQueryService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories.RentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RentQueryServiceImpl implements RentQueryService {

    private final RentRepository rentRepository;

    public RentQueryServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Optional<Rent> handle(GetRentByIdQuery query) {
        return rentRepository.findById(query.id());
    }

    @Override
    public List<Rent> handle(GetAllRentsQuery query) {
        return rentRepository.findAll();
    }

    @Override
    public List<Rent> handle(GetRentDateTimeBetweenQuery query) {
        return rentRepository.findByDateTimeBetween(query.start(), query.end());
    }

    @Override
    public List<Rent> handle(GetRentStatusQuery query) {
        return rentRepository.findByStatus(query.status());
    }
}