package pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {
    List<PaymentMethod> findByUser(User user);

    List<PaymentMethod> findByUserId(Integer user_id);

    @Query("SELECT pm FROM PaymentMethod pm WHERE pm.user.id = :userId AND pm.expiryDate > CURRENT_DATE")
    List<PaymentMethod> findValidPaymentMethodsByUserId(@Param("userId") Long userId);
}
