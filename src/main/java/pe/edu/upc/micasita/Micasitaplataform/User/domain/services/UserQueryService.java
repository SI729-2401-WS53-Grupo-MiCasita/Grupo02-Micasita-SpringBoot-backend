package pe.edu.upc.micasita.Micasitaplataform.User.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries.*;

import java.util.List;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    User handle(GetUserByIdQuery query);
    User handle(CreateUserQuery query);
    User handle(UpdateUserQuery query);
    void handle(DeleteUserQuery query);
}
