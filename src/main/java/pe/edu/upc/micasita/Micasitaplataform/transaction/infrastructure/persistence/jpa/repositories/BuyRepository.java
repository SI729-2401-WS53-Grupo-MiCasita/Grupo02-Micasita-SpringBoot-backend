package pe.edu.upc.micasita.Micasitaplataform.transaction.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.UserID;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {
    List<Buy> findByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Buy> findByStatus(String status);
    //Optional<Buy> findByUserID(UserID userID);
    boolean existsByUserID(UserID userID);
    boolean existsByUserIDAndIdIsNot(UserID userID, Long id);
}
