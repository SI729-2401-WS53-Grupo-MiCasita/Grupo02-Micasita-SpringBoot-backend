package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.AddPaymentMethodCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.DeletePaymentMethodCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.UpdateBillingAddressCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;

import java.util.Optional;

public interface PaymentMethodCommandService {
    Integer handle(AddPaymentMethodCommand command);

    Optional<PaymentMethod> handle(UpdateBillingAddressCommand command);

    void handle(DeletePaymentMethodCommand command);

}
