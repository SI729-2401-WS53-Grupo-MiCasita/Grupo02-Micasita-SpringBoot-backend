package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.services;

import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.entities.PaymentMethod;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetAllPaymentMethodsFromUserQuery;
import pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.queries.GetAllPaymentMethodsQuery;

import java.util.List;


public interface PaymentMethodQueryService {
    List<PaymentMethod> handle(GetAllPaymentMethodsQuery query);
    List<PaymentMethod> handle(GetAllPaymentMethodsFromUserQuery query);
}
