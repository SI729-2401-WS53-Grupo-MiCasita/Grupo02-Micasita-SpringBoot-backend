package pe.edu.upc.micasita.Micasitaplataform.users.domain.model.commads;

public record UpdateUserCommand(Long id,
                                String name,
                                String dni,
                                String email,
                                String password,
                                String phone,
                                String address) {
}
