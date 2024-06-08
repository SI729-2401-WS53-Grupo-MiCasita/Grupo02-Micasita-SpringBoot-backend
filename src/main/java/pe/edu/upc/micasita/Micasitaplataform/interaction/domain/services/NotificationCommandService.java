package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.CreateNotificationCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.DeleteNotificationCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.DeletePaymentMethodCommand;

public interface NotificationCommandService {
    Integer handle (CreateNotificationCommand command);
    void handle (DeleteNotificationCommand command);
}
