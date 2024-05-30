package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Amount;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.DateTime;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Status;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.PropertiesImpl;

public interface Buy {
    Integer getId();
    void setId(Integer id);

    User getUser();
    void setUser(User user);

    PropertiesImpl getProperty();
    void setProperty(PropertiesImpl property);

    DateTime getDateTime();
    void setDateTime(DateTime dateTime);

    Amount getAmount();
    void setAmount(Amount amount);

    Status getStatus();
    void setStatus(Status status);
}