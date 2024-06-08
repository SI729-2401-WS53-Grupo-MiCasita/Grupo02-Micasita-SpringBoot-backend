package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.PropertiesId;

public record AddPropertyToFavoritesCommand(Long userId, PropertiesId propertyId) {
}
