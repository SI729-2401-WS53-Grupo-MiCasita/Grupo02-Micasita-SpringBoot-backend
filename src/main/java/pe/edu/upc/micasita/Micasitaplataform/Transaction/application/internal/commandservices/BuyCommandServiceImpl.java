package pe.edu.upc.micasita.Micasitaplataform.Transaction.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.CreateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services.BuyCommandService;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.infrastructure.persistence.jpa.BuyRepository;

@Service
public class BuyCommandServiceImpl implements BuyCommandService {
    private final BuyRepository buyRepository;

    public BuyCommandServiceImpl(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }
    @Override
    public Long handle(CreateBuyCommand command){
        if (buyRepository.findBuyByUserInfoNameAndUserInfoDni(command.name(), command.dni()).isPresent()) {
            throw new IllegalArgumentException("Buy with same name and dni already exists");
        }
        if (buyRepository.findBuyByIdPropertyAndUserInfoNameAndUserInfoDni(command.idProperty(), command.name(), command.dni()).isPresent()) {
            throw new IllegalArgumentException("Buy with same idProperty, name and dni already exists");
        }
        var buy = new Buy(command);

        try {
            buyRepository.save(buy);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving buy: " + e.getMessage());
        }

        return buy.getIdBuy();
    }
}
