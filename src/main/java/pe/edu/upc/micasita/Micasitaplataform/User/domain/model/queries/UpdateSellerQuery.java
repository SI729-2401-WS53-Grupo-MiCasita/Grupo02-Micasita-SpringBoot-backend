package pe.edu.upc.micasita.Micasitaplataform.User.domain.model.queries;

import pe.edu.upc.micasita.Micasitaplataform.User.domain.model.aggregates.Sellers;

public record UpdateSellerQuery(Integer id, Sellers sellerDetails) { }
