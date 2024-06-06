package pe.edu.upc.micasita.Micasitaplataform.controllers.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate.Events;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate.Publications;
import pe.edu.upc.micasita.Micasitaplataform.communication.domain.model.aggregate.Visits;
import pe.edu.upc.micasita.Micasitaplataform.controllers.domain.model.valueobjects.*;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.TransactionEvents;

@Entity
public class Controllers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserID userID;
    @Embedded
    private PropertiesID propertiesID;
    @Embedded
    private EventsID eventsID;
    @Embedded
    private PublicationsID publicationsID;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Properties properties;

    @ManyToOne
    @JoinColumn(name = "events_id", nullable = false)
    private Events events;

    @ManyToOne
    @JoinColumn(name = "publications_id", nullable = false)
    private Publications publications;

    @ManyToOne
    @JoinColumn(name = "visits_id", nullable = false)
    private Visits visits;

    @ManyToOne
    @JoinColumn(name = "transaction_events_id")
    private TransactionEvents transactionEvents;

    // Rest of your fields...
}