package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Favorites;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetFavouritesPropertiesFromUserQuery;

import java.util.List;

public interface FavoritesQueryService {
    List<Favorites> handle(GetFavouritesPropertiesFromUserQuery query);
}
