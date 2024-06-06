package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries;

import java.math.BigDecimal;

public record GetPropertyByPriceRangeQuery(BigDecimal minPrice, BigDecimal maxPrice) {
}