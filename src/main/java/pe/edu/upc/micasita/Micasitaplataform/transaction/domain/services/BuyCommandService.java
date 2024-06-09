package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateBuyCommand;

import java.util.Optional;

public interface BuyCommandService {
    Long handle(CreateBuyCommand command);
    Optional<Buy> handle(UpdateBuyCommand command);
    void handle(DeleteBuyCommand command);
}
