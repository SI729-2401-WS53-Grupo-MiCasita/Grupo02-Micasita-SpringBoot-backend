package pe.edu.upc.micasita.Micasitaplataform.Property.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.PropertyImage;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries.GetPropertyImageByIdQuery;

import java.util.Optional;

public interface PropertyImageQueryService {
    Optional<PropertyImage> handle(GetPropertyImageByIdQuery query);
}
