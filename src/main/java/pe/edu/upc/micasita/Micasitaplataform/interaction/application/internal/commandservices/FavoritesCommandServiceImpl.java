package pe.edu.upc.micasita.Micasitaplataform.interaction.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.AddPropertyToFavoritesCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.DeletePropertyFromFavoritesCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.Favorites;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services.FavoritesCommandService;
import pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories.FavoritesRepository;

@Service
public class FavoritesCommandServiceImpl implements FavoritesCommandService {

    private final FavoritesRepository favoritesRepository;

    public FavoritesCommandServiceImpl(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public Long handle(AddPropertyToFavoritesCommand command) {
        if (favoritesRepository.existsById(command.propertyId().propertiesId())) {
            throw new IllegalArgumentException("Ya se ha marcado dicha propiedad como favorita");
        }
        var favorites = new Favorites(command);
        try {
            favoritesRepository.save(favorites);  // Corregido: ahora se pasa un objeto Favorites
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al guardar en favoritos");
        }
        return favorites.getId();
    }

    @Override
    public void handle(DeletePropertyFromFavoritesCommand command) {
        var favoritesId = command.favoriteId();
        if (!favoritesRepository.existsById(favoritesId)) {
            throw new IllegalArgumentException("La propiedad no está en la lista de favoritos");
        }
        try {
            favoritesRepository.deleteById(favoritesId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al eliminar de favoritos");
        }
    }
}

