package pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Favorites;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    Optional<Favorites> findByPropertiesId(Long propertiesId);
    List<Favorites> findByUserId(Long userId);
}

