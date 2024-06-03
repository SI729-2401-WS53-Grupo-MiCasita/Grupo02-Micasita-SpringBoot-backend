package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.entities.User;

public record UpdateUserQuery(Integer id, User userDetails) {}

