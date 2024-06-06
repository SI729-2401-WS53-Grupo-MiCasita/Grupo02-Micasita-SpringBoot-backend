package pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries;

public record GetPropertyByPriceRangeQuery(Long minPrice, Long maxPrice) {
}