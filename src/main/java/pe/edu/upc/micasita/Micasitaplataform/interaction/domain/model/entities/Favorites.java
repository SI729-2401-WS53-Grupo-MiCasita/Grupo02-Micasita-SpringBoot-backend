package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects.PropertiesID;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.valueobjects.UserID;

@Setter
@Getter
@Entity
public class Favorites {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

    @ManyToOne // Cambiado de @OneToOne a @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Constructor vacío
    public Favorites() {}

}
