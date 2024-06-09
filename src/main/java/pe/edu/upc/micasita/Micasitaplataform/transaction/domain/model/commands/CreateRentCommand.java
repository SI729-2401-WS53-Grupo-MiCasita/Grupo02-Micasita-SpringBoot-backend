package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands;

import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.time.LocalDateTime;

public record CreateRentCommand(UserID userID, LocalDateTime dateTime, String status, Properties properties) {
}