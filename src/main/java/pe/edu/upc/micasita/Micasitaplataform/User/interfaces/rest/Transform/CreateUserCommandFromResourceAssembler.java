package pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Transform;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands.CreateUserCommand;
import pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Resource.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.name(),
                resource.email(),
                resource.password(),
                resource.phone(),
                resource.dni(),
                resource.address()
        );
    }

}
