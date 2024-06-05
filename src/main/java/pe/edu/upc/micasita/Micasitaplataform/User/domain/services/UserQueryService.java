package pe.edu.upc.micasita.Micasitaplataform.User.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.CreateUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
   Optional<User> handle(GetUserByIdQuery query);

}
