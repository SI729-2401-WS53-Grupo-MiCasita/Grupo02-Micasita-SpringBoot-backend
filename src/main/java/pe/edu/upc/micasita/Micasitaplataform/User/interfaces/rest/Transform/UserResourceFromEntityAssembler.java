package pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Resource.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getPhone(),
                entity.getDni(),
                entity.getAddress());

    }
}
