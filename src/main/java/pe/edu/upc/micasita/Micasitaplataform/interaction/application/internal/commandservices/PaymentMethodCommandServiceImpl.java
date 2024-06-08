package pe.edu.upc.micasita.Micasitaplataform.interaction.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.BillingAddress;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.AddPaymentMethodCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.DeletePaymentMethodCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands.UpdateBillingAddressCommand;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services.PaymentMethodCommandService;
import pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;

import java.util.Optional;

@Service
public class PaymentMethodCommandServiceImpl implements PaymentMethodCommandService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodCommandServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public Integer handle(AddPaymentMethodCommand command) {
        var paymentMethod = new PaymentMethod();
        try {
            paymentMethodRepository.save(paymentMethod);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al agregar el método de pago");
        }
        return paymentMethod.getId();
    }

    @Override
    public Optional<PaymentMethod> handle(UpdateBillingAddressCommand command) {
        var existingPaymentMethod = paymentMethodRepository.findByUserId(command.userId());
        existingPaymentMethod.ifPresent(paymentMethod -> {
            var newBillingAddress = new BillingAddress(command.newBillingAddress()); // Crear un objeto BillingAddress con el String proporcionado
            paymentMethod.setBillingAddress(newBillingAddress);
            paymentMethodRepository.save(paymentMethod);
        });
        return existingPaymentMethod;
    }


    @Override
    public void handle(DeletePaymentMethodCommand command) {
        var paymentMethodId = command.paymentMethodId();
        try {
            paymentMethodRepository.deleteById(Math.toIntExact(paymentMethodId));
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al eliminar el método de pago");
        }
    }
}
