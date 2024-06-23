package pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services;


import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.CreateRentCommand;

public interface RentCommandService {
    Long handle(CreateRentCommand command);
}
