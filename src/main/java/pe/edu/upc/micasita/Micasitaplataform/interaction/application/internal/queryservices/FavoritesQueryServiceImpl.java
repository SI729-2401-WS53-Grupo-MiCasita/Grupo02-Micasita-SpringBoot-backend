package pe.edu.upc.micasita.Micasitaplataform.interaction.application.internal.queryservices;

import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Favorites;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetFavouritesPropertiesFromUserQuery;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services.FavoritesQueryService;
import pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories.FavoritesRepository;

import java.util.List;

public class FavoritesQueryServiceImpl implements FavoritesQueryService {
    private final FavoritesRepository favoritesRepository;

    public FavoritesQueryServiceImpl(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public List<Favorites> handle(GetFavouritesPropertiesFromUserQuery query) {
        return favoritesRepository.findByUserId(query.userId().userID());
    }
}
