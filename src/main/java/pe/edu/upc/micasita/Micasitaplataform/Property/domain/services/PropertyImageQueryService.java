package pe.edu.upc.micasita.Micasitaplataform.Property.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.entities.PropertyImage;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries.GetPropertyImageByIdQuery;

import java.util.Optional;

public interface PropertyImageQueryService {
    Optional<PropertyImage> handle(GetPropertyImageByIdQuery query);
}
