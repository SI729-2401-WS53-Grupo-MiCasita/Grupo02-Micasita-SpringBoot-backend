package pe.edu.upc.micasita.Micasitaplataform.User.interfaces.rest.Resource;

import jdk.jshell.Snippet;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Address;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.DNI;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Email;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Phone;

public record UserResource(String name,
                           Email email,
                           String password,
                           Phone phone,
                           DNI dni,
                           Address address) {
}
