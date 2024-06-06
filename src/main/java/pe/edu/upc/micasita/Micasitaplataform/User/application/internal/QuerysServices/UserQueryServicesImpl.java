package pe.edu.upc.micasita.Micasitaplataform.User.application.internal.QuerysServices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.services.UserQueryService;
import pe.edu.upc.micasita.Micasitaplataform.User.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserQueryServicesImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return this.userRepository.findById(query.userId());
    }
}
