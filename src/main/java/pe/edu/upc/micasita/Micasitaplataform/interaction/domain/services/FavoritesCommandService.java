package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.AddPropertyToFavoritesCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.DeletePropertyFromFavoritesCommand;

public interface FavoritesCommandService {
    Long handle(AddPropertyToFavoritesCommand command);
    void handle(DeletePropertyFromFavoritesCommand command);
}

