package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.exceptions;

public class PaymentMethodNotFoundException extends RuntimeException{
    public PaymentMethodNotFoundException(Long aLong) {super ("PaymentMethod" + aLong + "not found");}
}
