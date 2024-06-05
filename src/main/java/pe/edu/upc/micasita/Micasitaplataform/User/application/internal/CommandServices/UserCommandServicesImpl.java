package pe.edu.upc.micasita.Micasitaplataform.User.application.internal.CommandServices;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.CreateUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.DeleteUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.UpdateUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.services.UserCommandService;
import pe.edu.upc.micasita.Micasitaplataform.User.infrastructure.persistence.jpa.repositories.UserRepository;

public class UserCommandServicesImpl  implements UserCommandService {

private  final UserRepository userRepository;

    public UserCommandServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Long handle(CreateUserCommand command) {
        if (userRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (userRepository.existsByDni(command.dni())) {
            throw new IllegalArgumentException("Username already exists");
        }
        var user = new User(command);
        try {
            userRepository.save(user);
        } catch (Exception e){
            throw new RuntimeException("Error while saving user");
        }
        return 0L;
    }

    @Override
    public Long handle(UpdateUserCommand command) {
        if (userRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (userRepository.existsByDni(command.dni())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByname(command.name())) {
            throw new IllegalArgumentException("Username already exists");
        }
        var user= new User(command);
        try {
            userRepository.save(user);
        } catch (Exception e){
            throw new RuntimeException("Error while saving user");
        }
        return 0L;
    }

    @Override
    public Long handle(DeleteUserCommand command) {
        var user = userRepository.findById(String.valueOf(command.id())).orElseThrow(() -> new IllegalArgumentException("User not found"));
        try {
            userRepository.delete(user);
        } catch (Exception e){
            throw new RuntimeException("Error while deleting user");
        }
        return 0L;
    }
}
