package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources;


public record PropertyResource(Long Id,
                               String title,
                               String description,
                               Long price,
                               String location,
                               String status,
                               String type,
                               Long size,
                               Integer bedrooms,
                               Integer bathrooms,
                               Integer garageSpace,
                               Integer yearBuilt) {
}