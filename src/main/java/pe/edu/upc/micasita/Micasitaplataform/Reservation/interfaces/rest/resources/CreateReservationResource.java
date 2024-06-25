package pe.edu.upc.micasita.Micasitaplataform.Reservation.interfaces.rest.resources;

import pe.edu.upc.micasita.Micasitaplataform.Reservation.domain.model.valueobjects.ReservationStatus;

import java.time.LocalDateTime;

public record CreateReservationResource(Long userId,
                                        Long propertyId,
                                        LocalDateTime dateTime,
                                        ReservationStatus status) {
}
