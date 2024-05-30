package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.PaymentMethodRepository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.PaymentMethods;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.PaymentMethod;

import java.util.List;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethod> findAll() {
        return paymentMethodRepository.findAll();
    }

    public PaymentMethod save(PaymentMethod paymentmethod) {
        return paymentMethodRepository.save(paymentmethod);
    }

    public void deleteById(Integer id) {
        paymentMethodRepository.deleteById(id);
    }
}

