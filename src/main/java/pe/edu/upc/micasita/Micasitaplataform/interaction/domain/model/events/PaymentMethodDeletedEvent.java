package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.events;

public class PaymentMethodDeletedEvent {
    private Integer paymentMethodId;
    private Integer userId;

    public PaymentMethodDeletedEvent(Integer paymentMethodId, Integer userId) {
        this.paymentMethodId = paymentMethodId;
        this.userId = userId;
    }

    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
