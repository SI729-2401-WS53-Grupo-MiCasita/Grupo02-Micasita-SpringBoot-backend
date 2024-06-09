package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentMethodDeletedEvent {
    private Integer paymentMethodId;
    private Integer userId;

    public PaymentMethodDeletedEvent(Integer paymentMethodId, Integer userId) {
        this.paymentMethodId = paymentMethodId;
        this.userId = userId;
    }

}
