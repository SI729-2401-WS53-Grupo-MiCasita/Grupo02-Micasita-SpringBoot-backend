package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities;
import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.NotificationMessage;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.NotificationStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "message", nullable = false, length = 255))
    private NotificationMessage message;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "status", nullable = false, length = 15))
    private NotificationStatus status;
}