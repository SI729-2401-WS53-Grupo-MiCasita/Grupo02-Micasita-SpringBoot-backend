package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.Favorites;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.infrastructure.persistence.jpa.repositories.FavoriteRepository;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorites> findAll() {
        return favoriteRepository.findAll();
    }

    public Favorites save(Favorites favorites) {
        return favoriteRepository.save(favorites);
    }

    public void deleteById(Integer id) {
        favoriteRepository.deleteById(id);
    }
}
