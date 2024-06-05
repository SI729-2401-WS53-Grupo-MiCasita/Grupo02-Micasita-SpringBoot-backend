package pe.edu.upc.micasita.Micasitaplataform.User.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.CreateUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.DeleteUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.UpdateUserCommand;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
    Long handle(UpdateUserCommand command);
    Long handle(DeleteUserCommand command);
}
