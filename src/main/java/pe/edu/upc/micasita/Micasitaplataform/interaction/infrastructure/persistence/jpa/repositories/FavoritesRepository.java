package pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Favorites;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
    List<Favorites> findByUserId(Integer user_id);

    @Query("SELECT f FROM Favorites f WHERE f.user.id = :userId")
    List<Favorites> findFavoritesByUserId(@Param("userId") Long userId);

    @Query("SELECT f FROM Favorites f WHERE f.properties.id = :propertyId")
    List<Favorites> findFavoritesByPropertyId(@Param("propertyId") Long propertyId);

    @Query("SELECT COUNT(f) FROM Favorites f WHERE f.user.id = :userId")
    Long countByUserId(@Param("userId") Long userId);
}
