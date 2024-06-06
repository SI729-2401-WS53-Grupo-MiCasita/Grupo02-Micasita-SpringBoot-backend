package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources;

public record CreatePropertyResource(String propertyName,
                                     String propertyType,
                                     String propertyLocation,
                                     Long propertyPrice) {
}