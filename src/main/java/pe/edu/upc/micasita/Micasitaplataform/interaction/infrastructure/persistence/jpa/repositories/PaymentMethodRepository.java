package pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.CardNumber;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Integer> {
    Optional <PaymentMethod> findByUserId(Integer userId);
    boolean existsByUserIdAndCardNumber(Integer user_id, @NotNull CardNumber cardNumber);
    List<PaymentMethod> findByUserId(Long userId);
}
