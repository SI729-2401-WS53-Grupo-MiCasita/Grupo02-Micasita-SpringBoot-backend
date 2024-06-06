package pe.edu.upc.micasita.Micasitaplataform.Property.domain.services;


import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;

import java.util.Optional;

public interface PropertyCommandService {
    Integer handle(AddPropertyCommand command);
    Optional<Properties> handle(UpdatePropertyCommand command);
    void handle(DeletePropertyCommand command);

    void handle(ChangePropertyStatusCommand command);
    void handle(ChangePropertyPriceCommand command);
    void handle(ChangePropertyTypeCommand command);
    void handle(ChangePropertyDescriptionCommand command);
    void handle(ChangePropertyLocationCommand command);
}