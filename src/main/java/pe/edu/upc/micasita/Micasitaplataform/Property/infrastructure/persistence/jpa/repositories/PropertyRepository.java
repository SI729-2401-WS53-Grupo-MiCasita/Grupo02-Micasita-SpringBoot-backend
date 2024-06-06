package pe.edu.upc.micasita.Micasitaplataform.Property.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.valueobjects.Status;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.valueobjects.SellerID;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Properties, Integer> {
    Optional<Properties> findByLocation(@NonNull String location);

    boolean existsByLocation(@NonNull String location);
    boolean existsByLocationAndIdIsNot(@NonNull String location, @NonNull Integer id);

    Optional<Properties> findBySellerID(@NonNull SellerID sellerID);

    Optional<Properties> findByBedrooms(@NonNull Integer bedrooms);

    List<Properties> findByPriceBetween(@NonNull Long Long1, @NonNull Long Long2);

    Optional<Properties> findByStatus(@NonNull Status status);

    Optional<Properties> findByType(@NonNull String type);

    List<Properties> findBySizeBetween(@NonNull Long Long1, @NonNull Long Long2);

    Optional<Properties> findByBathrooms(@NonNull Integer bathrooms);

    Optional<Properties> findByGarageSpace(@NonNull Integer integer);

    Optional<Properties> findByYearBuilt(@NonNull Integer integer);

    @NonNull
    Optional<Properties> findById(@NonNull Integer id);
    @NonNull
    List<Properties> findAll();
}