package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.PaymentMethodRepository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.PaymentMethod;


import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public Optional<PaymentMethod> getPaymentMethodById(Integer id) {
        return paymentMethodRepository.findById(id);
    }

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod updatePaymentMethod(Integer id, PaymentMethod paymentMethodDetails) {
        return paymentMethodRepository.findById(id)
                .map(paymentMethod -> {
                    paymentMethod.setCardNumber(paymentMethodDetails.getCardNumber());
                    paymentMethod.setExpiryDate(paymentMethodDetails.getExpiryDate());
                    paymentMethod.setCardholderName(paymentMethodDetails.getCardholderName());
                    paymentMethod.setBillingAddress(paymentMethodDetails.getBillingAddress());
                    paymentMethod.setUser(paymentMethodDetails.getUser());
                    return paymentMethodRepository.save(paymentMethod);
                })
                .orElseGet(() -> {
                    paymentMethodDetails.setId(id);
                    return paymentMethodRepository.save(paymentMethodDetails);
                });
    }

    public void deletePaymentMethod(Integer id) {
        paymentMethodRepository.deleteById(id);
    }
}