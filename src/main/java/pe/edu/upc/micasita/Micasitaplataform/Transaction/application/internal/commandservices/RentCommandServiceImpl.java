package pe.edu.upc.micasita.Micasitaplataform.Transaction.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.commands.CreateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services.RentCommandService;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.infrastructure.persistence.jpa.RentRepository;

@Service
public class RentCommandServiceImpl implements RentCommandService {
    private final RentRepository rentRepository;

    public RentCommandServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Long handle(CreateRentCommand command){
        if (rentRepository.findRentByUserInfoNameAndUserInfoDniAndUserInfoPhoneNumber(command.name(), command.dni(), command.phoneNumber()).isPresent()) {
            throw new IllegalArgumentException("Rent with same name, dni and phone number already exists");
        }
        if (rentRepository.findRentByIdPropertyAndUserInfoNameAndUserInfoDni(command.idProperty(), command.name(), command.dni()).isPresent()) {
            throw new IllegalArgumentException("Rent with same idProperty, name and dni already exists");
        }
        var rent = new Rent(command);

        try {
            rentRepository.save(rent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving rent: " + e.getMessage());
        }

        return rent.getIdRent();
    }
}