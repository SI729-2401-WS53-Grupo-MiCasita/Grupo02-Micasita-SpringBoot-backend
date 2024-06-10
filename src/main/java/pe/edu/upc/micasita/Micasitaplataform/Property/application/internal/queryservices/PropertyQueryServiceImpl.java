package pe.edu.upc.micasita.Micasitaplataform.Property.application.internal.queryservices;


import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.services.PropertyQueryService;
import pe.edu.upc.micasita.Micasitaplataform.Property.infrastructure.persistence.jpa.repositories.PropertyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyQueryServiceImpl implements PropertyQueryService {

    private final PropertyRepository propertyRepository;

    public PropertyQueryServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }
    @Override
    public Optional<Properties> handle(GetPropertyByLocationQuery query) {
        return propertyRepository.findByLocation(query.location());
    }

    @Override
    public List<Properties> handle(GetPropertyByPriceRangeQuery query) {
        return propertyRepository.findByPriceBetween(query.minPrice(), query.maxPrice());
    }

    @Override
    public Optional<Properties> handle(GetPropertyByStatusQuery query) {
        return propertyRepository.findByStatus(query.status());
    }

    @Override
    public Optional<Properties> handle(GetPropertyByTypeQuery query) {
        return propertyRepository.findByType(query.type());
    }

    @Override
    public List<Properties> handle(GetPropertyBySizeRangeQuery query) {
        return propertyRepository.findBySizeBetween(query.minSize(), query.maxSize());
    }

    @Override
    public Optional<Properties> handle(GetPropertyByBedroomsQuery query) {
        return propertyRepository.findByBedrooms(query.bedrooms());
    }

    @Override
    public Optional<Properties> handle(GetPropertyByBathroomsQuery query) {
        return propertyRepository.findByBathrooms(query.bathrooms());
    }

    @Override
    public Optional<Properties> handle(GetPropertyByGarageSpaceQuery query) {
        return propertyRepository.findByGarageSpace(query.garageSpace());
    }

    @Override
    public Optional<Properties> handle(GetPropertyByYearBuiltQuery query) {
        return propertyRepository.findByYearBuilt(query.yearBuilt());
    }

    @Override
    public Optional<Properties> handle(GetPropertyBySellerIDQuery query) {
        return propertyRepository.findBySellerID(query.sellerID());
    }

    @Override
    public Optional<Properties> handle(GetPropertyByIdQuery query) {
        return propertyRepository.findById(query.propertyId());
    }

    @Override
    public List<Properties> handle(GetAllPropertiesQuery query) {
        return propertyRepository.findAll();
    }
}