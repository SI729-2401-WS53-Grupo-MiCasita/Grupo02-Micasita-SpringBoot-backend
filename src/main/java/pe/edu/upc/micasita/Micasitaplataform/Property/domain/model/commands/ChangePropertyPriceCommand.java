package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands;
import java.math.BigDecimal;

public record ChangePropertyPriceCommand(Integer id, BigDecimal newPrice) {
}