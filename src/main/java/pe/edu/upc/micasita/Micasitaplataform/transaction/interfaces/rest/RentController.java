package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Rent;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateRentCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetRentByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.RentCommandService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.RentQueryService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.RentResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.CreateRentResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.UpdateRentResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.RentResourceFromEntityAssembler;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.CreateRentCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.UpdateRentCommandFromResourceAssembler;

@RestController
@RequestMapping(value = "/api/v1/rents", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Rents", description = "Rent Management Endpoints")
public class RentController {
    private final RentCommandService rentCommandService;
    private final RentQueryService rentQueryService;

    public RentController(RentCommandService rentCommandService, RentQueryService rentQueryService) {
        this.rentCommandService = rentCommandService;
        this.rentQueryService = rentQueryService;
    }

    @PostMapping
    public ResponseEntity<RentResource> createRent(@RequestBody CreateRentResource resource) {
        var createRentCommand = CreateRentCommandFromResourceAssembler.toCommandFromResource(resource);
        var rentId = rentCommandService.handle(createRentCommand);

        if (rentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        if (rent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent.get());
        return new ResponseEntity<>(rentResource, HttpStatus.CREATED);
    }

    @GetMapping("/{rentId}")
    public ResponseEntity<RentResource> getRentById(@PathVariable Long rentId) {
        var getRentByIdQuery = new GetRentByIdQuery(rentId);
        var rent = rentQueryService.handle(getRentByIdQuery);

        if (rent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(rent.get());
        return ResponseEntity.ok(rentResource);
    }

    @PutMapping("/{rentId}")
    public ResponseEntity<RentResource> updateRent(@PathVariable Long rentId, @RequestBody UpdateRentResource resource) {
        var updateRentCommand = UpdateRentCommandFromResourceAssembler.toCommandFromResource(rentId, resource);
        var updatedRent = rentCommandService.handle(updateRentCommand);

        if (updatedRent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var rentResource = RentResourceFromEntityAssembler.toResourceFromEntity(updatedRent.get());
        return ResponseEntity.ok(rentResource);
    }

    @DeleteMapping("/{rentId}")
    public ResponseEntity<?> deleteRent(@PathVariable Long rentId) {
        var deleteRentCommand = new DeleteRentCommand(rentId);
        rentCommandService.handle(deleteRentCommand);
        return ResponseEntity.ok("Rent with given id successfully deleted");
    }
}