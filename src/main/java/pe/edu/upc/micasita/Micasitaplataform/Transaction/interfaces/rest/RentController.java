package pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.queries.GetRentByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services.RentCommandService;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services.RentQueryService;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.resources.CreateRentResource;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.resources.RentResource;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.transform.CreateRentCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.transform.RentResourceFromEntityAssembler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/rents", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Rent", description = "Rent Management Endpoints")
public class RentController {
    private final RentCommandService rentCommandService;
    private final RentQueryService rentQueryService;

    public RentController(RentCommandService rentCommandService, RentQueryService rentQueryService) {
        this.rentCommandService = rentCommandService;
        this.rentQueryService = rentQueryService;
    }
    @PostMapping
    public ResponseEntity<RentResource> createRent(@RequestBody CreateRentResource createRentResource) {
        var createRentCommand = CreateRentCommandFromResourceAssembler.toCommandFromResource(createRentResource);
        var rentId = rentCommandService.handle(createRentCommand);

        if (rentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        if (rent.isEmpty())
            return ResponseEntity.badRequest().build();
        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent.get());
        return new ResponseEntity<>(rentResource, HttpStatus.CREATED);
    }
}