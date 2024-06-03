package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

public class FavoriteRemovedEvent {
    private Long favoriteId;
    private Long userId;
    private Long propertyId;

    public FavoriteRemovedEvent(Long favoriteId, Long userId, Long propertyId) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.propertyId = propertyId;
    }

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
