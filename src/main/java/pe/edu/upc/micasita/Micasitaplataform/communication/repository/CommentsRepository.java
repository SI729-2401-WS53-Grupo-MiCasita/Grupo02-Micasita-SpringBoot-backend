package pe.edu.upc.micasita.Micasitaplataform.communication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.entities.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}