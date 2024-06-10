package pe.edu.upc.micasita.Micasitaplataform.interaction.domain.model.commands;

import java.time.LocalDate;

public record AddPaymentMethodCommand(Integer userId, String cardNumber, LocalDate expiryDate, String cardholderName, String billingAddress) {

}

