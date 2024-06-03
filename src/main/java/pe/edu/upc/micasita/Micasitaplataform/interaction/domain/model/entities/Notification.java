package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities;
import lombok.*;
import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.NotificationMessage;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.NotificationStatus;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate.Publications;
import pe.edu.upc.micasita.Micasitaplataform.controllers.domain.model.entities.Controllers;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;

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

    @ManyToOne
    @JoinColumn(name = "publication_id", nullable = false)
    private Publications publications;

    @ManyToOne
    @JoinColumn(name = "controller_id", nullable = false)
    private Controllers controllers;

    @ManyToOne
    @JoinColumn(name = "transaction_events_id", nullable = false)
    private TransactionEvents transactionEvents;

}