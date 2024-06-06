package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources;

public record PropertyResource(Integer id,
                               String propertyName,
                               String propertyType,
                               String propertyLocation,
                               Long propertyPrice) {
}