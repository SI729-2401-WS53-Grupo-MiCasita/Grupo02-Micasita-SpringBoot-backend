package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands;



public record AddPropertyCommand(String title,
                                 String description,
                                 Long price,
                                 String location,
                                 String status,
                                 String type,
                                 Long size,
                                 Integer bedrooms,
                                 Integer bathrooms,
                                 Integer garageSpace,
                                 Integer yearBuilt
                                 ) {
}
