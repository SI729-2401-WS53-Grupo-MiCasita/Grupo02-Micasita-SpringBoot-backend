package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FavoriteAddedEvent {
    private Long favoriteId;
    private Long userId;
    private Long propertyId;
    public FavoriteAddedEvent(Long favoriteId, Long userId, Long propertyId) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.propertyId = propertyId;
    }

}
