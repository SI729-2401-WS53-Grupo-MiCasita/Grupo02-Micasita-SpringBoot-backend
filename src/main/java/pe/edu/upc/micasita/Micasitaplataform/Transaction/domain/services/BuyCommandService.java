package pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.CreateBuyCommand;

public interface BuyCommandService {
    Long handle(CreateBuyCommand command);
}
