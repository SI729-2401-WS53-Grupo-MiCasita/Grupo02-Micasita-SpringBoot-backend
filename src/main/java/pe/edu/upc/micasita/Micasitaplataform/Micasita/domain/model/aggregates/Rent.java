package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.User;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.DateTime;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Status;

public interface Rent {
    Integer getId();
    void setId(Integer id);

    User getUser();
    void setUser(User user);

    Properties getProperty();
    void setProperty(Properties property);

    DateTime getDate();
    void setDate(DateTime date);

    Status getStatus();
    void setStatus(Status status);
}