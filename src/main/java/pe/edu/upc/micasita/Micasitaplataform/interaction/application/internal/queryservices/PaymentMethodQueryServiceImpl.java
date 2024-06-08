package pe.edu.upc.micasita.Micasitaplataform.interaction.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetAllPaymentMethodsFromUserQuery;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetAllPaymentMethodsQuery;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services.PaymentMethodQueryService;
import pe.edu.upc.micasita.Micasitaplataform.interaction.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;

import java.util.List;

@Service
public class PaymentMethodQueryServiceImpl implements PaymentMethodQueryService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodQueryServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<PaymentMethod> handle(GetAllPaymentMethodsQuery query) {
        return paymentMethodRepository.findAll();
    }

    @Override
    public List<PaymentMethod> handle(GetAllPaymentMethodsFromUserQuery query) {
        return paymentMethodRepository.findByUserId(query.userId().userID());
    }
}
