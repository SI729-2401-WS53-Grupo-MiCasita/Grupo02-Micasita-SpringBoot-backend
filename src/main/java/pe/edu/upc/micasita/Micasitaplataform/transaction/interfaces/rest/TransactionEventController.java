package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteTransactionEventCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetTransactionEventByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.valueobjects.TransactionID;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.TransactionEventCommandService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.TransactionEventQueryService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.TransactionEventResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.CreateTransactionEventResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.UpdateTransactionEventResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.TransactionEventResourceFromEntityAssembler;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.CreateTransactionEventCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.UpdateTransactionEventCommandFromResourceAssembler;

@RestController
@RequestMapping(value = "/api/v1/transactionEvents", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "TransactionEvents", description = "Transaction Event Management Endpoints")
public class TransactionEventController {
    private final TransactionEventCommandService transactionEventCommandService;
    private final TransactionEventQueryService transactionEventQueryService;

    public TransactionEventController(TransactionEventCommandService transactionEventCommandService, TransactionEventQueryService transactionEventQueryService) {
        this.transactionEventCommandService = transactionEventCommandService;
        this.transactionEventQueryService = transactionEventQueryService;
    }

    @PostMapping
    public ResponseEntity<TransactionEventResource> createTransactionEvent(@RequestBody CreateTransactionEventResource resource) {
        var createTransactionEventCommand = CreateTransactionEventCommandFromResourceAssembler.toCommandFromResource(resource);
        var transactionEventId = transactionEventCommandService.handle(createTransactionEventCommand);

        if (transactionEventId == null) {
            return ResponseEntity.badRequest().build();
        }
        var getTransactionEventByIdQuery = new GetTransactionEventByIdQuery(new TransactionID(transactionEventId));
        var transactionEvent = transactionEventQueryService.handle(getTransactionEventByIdQuery);

        if (transactionEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var transactionEventResource = TransactionEventResourceFromEntityAssembler.toResourceFromEntity(transactionEvent.get());
        return new ResponseEntity<>(transactionEventResource, HttpStatus.CREATED);
    }

    @GetMapping("/{transactionEventId}")
    public ResponseEntity<TransactionEventResource> getTransactionEventById(@PathVariable TransactionID transactionEventId) {
        var getTransactionEventByIdQuery = new GetTransactionEventByIdQuery(transactionEventId);
        var transactionEvent = transactionEventQueryService.handle(getTransactionEventByIdQuery);

        if (transactionEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var transactionEventResource = TransactionEventResourceFromEntityAssembler.toResourceFromEntity(transactionEvent.get());
        return ResponseEntity.ok(transactionEventResource);
    }

    @PutMapping("/{transactionEventId}")
    public ResponseEntity<TransactionEventResource> updateTransactionEvent(@PathVariable Long transactionEventId, @RequestBody UpdateTransactionEventResource resource) {
        var updateTransactionEventCommand = UpdateTransactionEventCommandFromResourceAssembler.toCommandFromResource(transactionEventId, resource);
        var updatedTransactionEvent = transactionEventCommandService.handle(updateTransactionEventCommand);

        if (updatedTransactionEvent.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var transactionEventResource = TransactionEventResourceFromEntityAssembler.toResourceFromEntity(updatedTransactionEvent.get());
        return ResponseEntity.ok(transactionEventResource);
    }

    @DeleteMapping("/{transactionEventId}")
    public ResponseEntity<?> deleteTransactionEvent(@PathVariable Long transactionEventId) {
        var deleteTransactionEventCommand = new DeleteTransactionEventCommand(transactionEventId);
        transactionEventCommandService.handle(deleteTransactionEventCommand);
        return ResponseEntity.ok("Transaction Event with given id successfully deleted");
    }
}