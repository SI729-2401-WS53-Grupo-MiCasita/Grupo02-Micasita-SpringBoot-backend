package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Status;

public record PropertyResource(Integer Id,
                               String title,
                               String description,
                               Long price,
                               String location,
                               Status status,
                               String type,
                               Long size,
                               Integer bedrooms,
                               Integer bathrooms,
                               Integer garageSpace,
                               Integer yearBuilt) {
}