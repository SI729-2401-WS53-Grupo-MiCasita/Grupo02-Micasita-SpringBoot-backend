package pe.edu.upc.micasita.Micasitaplataform.User.infrastructure.persistence.jpa.repositories;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.DNI;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Email;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Integer email);
    boolean existsByEmail(Email email);
    boolean existsByDni(DNI dni);
    boolean existsByname(String name);

}