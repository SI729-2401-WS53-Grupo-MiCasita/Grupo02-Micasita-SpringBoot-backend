package pe.edu.upc.micasita.Micasitaplataform.User.infrastructure.persistence.jpa.repositories;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}