package pe.edu.upc.micasita.Micasitaplataform.transaction.application.internal.CommandServices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.RentCommandService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories.RentRepository;

import java.util.Optional;

@Service
public class RentCommandServiceImpl implements RentCommandService {

    private final RentRepository rentRepository;

    public RentCommandServiceImpl(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Long handle(CreateRentCommand command) {
        if (rentRepository.existsByUserID(command.userID())) {
            throw new IllegalArgumentException("Rent with same user ID already exists");
        }
        var rent = new Rent(command);
        try {
            rentRepository.save(rent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving rent: " + e.getMessage());
        }
        return rent.getId();
    }

    @Override
    public Optional<Rent> handle(UpdateRentCommand command) {
        if (rentRepository.existsByUserIDAndIdIsNot(command.userID(), command.id()))
            throw new IllegalArgumentException("Rent with same user ID already exists");
        var result = rentRepository.findById(command.id());
        if (result.isEmpty())
            throw new IllegalArgumentException("Rent does not exist");
        var rentToUpdate = result.get();
        try {
            rentToUpdate.updateRent(command);
            var updatedRent = rentRepository.save(rentToUpdate);
            return Optional.of(updatedRent);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating rent: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteRentCommand command) {
        if (!rentRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Rent does not exist");
        }
        try {
            rentRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting rent: " + e.getMessage());
        }
    }
}