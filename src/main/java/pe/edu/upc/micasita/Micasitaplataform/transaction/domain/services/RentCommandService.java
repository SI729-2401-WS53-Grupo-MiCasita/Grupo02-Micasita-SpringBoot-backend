package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateRentCommand;

import java.util.Optional;

public interface RentCommandService {
    Long handle(CreateRentCommand command);
    Optional<Rent> handle(UpdateRentCommand command);
    void handle(DeleteRentCommand command);
}
