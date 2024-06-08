package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.PropertiesId;

import java.util.Objects;

@Embeddable
public record PropertiesID(Long propertiesID) {
    public PropertiesID() {
        this(0L);
    }
    public PropertiesID{
        if(propertiesID < 0){
            throw new IllegalArgumentException("Profile propertiesID cannot be negative");
        }
    }
    private static Long value = 0L;

    public void PropertiesId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertiesId that = (PropertiesId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PropertiesId{" +
                "value=" + value +
                '}';
    }
}
