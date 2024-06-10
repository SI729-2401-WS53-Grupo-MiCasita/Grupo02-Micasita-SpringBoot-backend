package pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries;

import java.time.LocalDateTime;

public record GetRentDateTimeBetweenQuery(LocalDateTime start, LocalDateTime end) {
}
