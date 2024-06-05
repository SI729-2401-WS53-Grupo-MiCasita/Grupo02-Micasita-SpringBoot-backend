package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Address;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.DNI;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Email;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Phone;

public record CreateUserCommand(String name,
                                Email email,
                                String password,
                                Phone phone,
                                DNI dni,
                                Address address) {


}
