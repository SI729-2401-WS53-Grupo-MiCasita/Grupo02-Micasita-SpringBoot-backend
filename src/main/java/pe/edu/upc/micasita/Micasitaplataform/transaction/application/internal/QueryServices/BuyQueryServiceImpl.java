package pe.edu.upc.micasita.Micasitaplataform.transaction.application.internal.QueryServices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetAllBuysQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetBuyByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetBuyDateTimeBetweenQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetBuyStatusQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.BuyQueryService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories.BuyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuyQueryServiceImpl implements BuyQueryService {

    private final BuyRepository buyRepository;

    public BuyQueryServiceImpl(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    @Override
    public Optional<Buy> handle(GetBuyByIdQuery query) {
        return buyRepository.findById(query.id());
    }

    @Override
    public List<Buy> handle(GetAllBuysQuery query) {
        return buyRepository.findAll();
    }

    @Override
    public List<Buy> handle(GetBuyDateTimeBetweenQuery query) {
        return buyRepository.findByDateTimeBetween(query.start(), query.end());
    }

    @Override
    public List<Buy> handle(GetBuyStatusQuery query) {
        return buyRepository.findByStatus(query.status());
    }
}