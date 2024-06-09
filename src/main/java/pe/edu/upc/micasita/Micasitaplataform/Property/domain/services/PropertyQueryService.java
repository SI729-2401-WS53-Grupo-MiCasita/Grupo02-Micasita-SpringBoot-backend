package pe.edu.upc.micasita.Micasitaplataform.Property.domain.services;


import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;

import java.util.List;
import java.util.Optional;

public interface PropertyQueryService {
    Optional<Properties> handle(GetPropertyByLocationQuery query);
    List<Properties> handle(GetPropertyByPriceRangeQuery query);
    Optional<Properties> handle(GetPropertyByStatusQuery query);
    Optional<Properties> handle(GetPropertyByTypeQuery query);
    List<Properties> handle(GetPropertyBySizeRangeQuery query);
    Optional<Properties> handle(GetPropertyByBedroomsQuery query);
    Optional<Properties> handle(GetPropertyByBathroomsQuery query);
    Optional<Properties> handle(GetPropertyByGarageSpaceQuery query);
    Optional<Properties> handle(GetPropertyByYearBuiltQuery query);
    Optional<Properties> handle(GetPropertyBySellerIDQuery query);
    Optional<Properties> handle(GetPropertyByIdQuery query);
    List<Properties> handle(GetAllPropertiesQuery query);
}