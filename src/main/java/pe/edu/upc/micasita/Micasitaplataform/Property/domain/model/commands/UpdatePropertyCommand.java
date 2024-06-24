package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands;



public record UpdatePropertyCommand(Long id,
                                    String title, String description, Long price, String location, String status,
                                    String type,
                                    Long size,
                                    Integer bedrooms,
                                    Integer bathrooms,
                                    Integer garageSpace,
                                    Integer yearBuilt) { }