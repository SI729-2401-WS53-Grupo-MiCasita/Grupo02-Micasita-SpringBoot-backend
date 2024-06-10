package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.commands;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.aggregates.Sellers;

public record CreateSellerCommand(Sellers seller) { }
