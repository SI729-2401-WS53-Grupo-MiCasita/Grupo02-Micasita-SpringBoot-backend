package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.TransactionID;

public record GetTransactionEventByIdQuery(TransactionID transactionID) {
}