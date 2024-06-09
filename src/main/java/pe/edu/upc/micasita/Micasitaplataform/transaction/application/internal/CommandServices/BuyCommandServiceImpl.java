package pe.edu.upc.micasita.Micasitaplataform.transaction.application.internal.CommandServices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.BuyCommandService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories.BuyRepository;

import java.util.Optional;

@Service
public class BuyCommandServiceImpl implements BuyCommandService {

    private final BuyRepository buyRepository;

    public BuyCommandServiceImpl(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    @Override
    public Long handle(CreateBuyCommand command) {
        if (buyRepository.existsByUserID(command.userID())) {
            throw new IllegalArgumentException("Buy with same user ID already exists");
        }
        var buy = new Buy(command);
        try {
            buyRepository.save(buy);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving buy: " + e.getMessage());
        }
        return buy.getId();
    }

    @Override
    public Optional<Buy> handle(UpdateBuyCommand command) {
        if (buyRepository.existsByUserIDAndIdIsNot(command.userID(), command.id()))
            throw new IllegalArgumentException("Buy with same user ID already exists");
        var result = buyRepository.findById(command.id());
        if (result.isEmpty())
            throw new IllegalArgumentException("Buy does not exist");
        var buyToUpdate = result.get();
        try {
            buyToUpdate.updateBuy(command);
            var updatedBuy = buyRepository.save(buyToUpdate);
            return Optional.of(updatedBuy);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating buy: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteBuyCommand command) {
        if (!buyRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Buy does not exist");
        }
        try {
            buyRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting buy: " + e.getMessage());
        }
    }
}