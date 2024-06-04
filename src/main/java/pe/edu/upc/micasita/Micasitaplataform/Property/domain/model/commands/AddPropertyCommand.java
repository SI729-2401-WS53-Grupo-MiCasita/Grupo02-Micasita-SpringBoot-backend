package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;

public record AddPropertyCommand(Properties property) {
}