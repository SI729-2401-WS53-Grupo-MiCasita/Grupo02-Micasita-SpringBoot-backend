package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentMethodAddedEvent {
    private Integer paymentMethodId;
    private Integer userId;

    public PaymentMethodAddedEvent(Integer paymentMethodId, Integer userId) {
        this.paymentMethodId = paymentMethodId;
        this.userId = userId;
    }

}

