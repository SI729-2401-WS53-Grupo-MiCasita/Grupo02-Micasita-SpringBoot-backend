package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.DateTime;

public interface TransactionEvents {
    Integer getId();
    void setId(Integer id);

    Integer getTransactionId();
    void setTransactionId(Integer transactionId);

    Integer getEventId();
    void setEventId(Integer eventId);

    DateTime getEventDate();
    void setEventDate(DateTime eventDate);

    Integer getRentId();
    void setRentId(Integer rentId);
}