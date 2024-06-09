package pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.aggregate.Buy;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.CreateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.DeleteBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.commands.UpdateBuyCommand;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.model.queries.GetBuyByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.BuyCommandService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.domain.services.BuyQueryService;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.BuyResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.CreateBuyResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Resource.UpdateBuyResource;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.BuyResourceFromEntityAssembler;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.CreateBuyCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.transaction.interfaces.rest.Transform.UpdateBuyCommandFromResourceAssembler;

@RestController
@RequestMapping(value = "/api/v1/buys", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Buys", description = "Buy Management Endpoints")
public class BuyController {
    private final BuyCommandService buyCommandService;
    private final BuyQueryService buyQueryService;

    public BuyController(BuyCommandService buyCommandService, BuyQueryService buyQueryService) {
        this.buyCommandService = buyCommandService;
        this.buyQueryService = buyQueryService;
    }

    @PostMapping
    public ResponseEntity<BuyResource> createBuy(@RequestBody CreateBuyResource resource) {
        var createBuyCommand = CreateBuyCommandFromResourceAssembler.toCommandFromResource(resource);
        var buyId = buyCommandService.handle(createBuyCommand);

        if (buyId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getBuyByIdQuery = new GetBuyByIdQuery(buyId);
        var buy = buyQueryService.handle(getBuyByIdQuery);

        if (buy.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var buyResource = BuyResourceFromEntityAssembler.toResourceFromEntity(buy.get());
        return new ResponseEntity<>(buyResource, HttpStatus.CREATED);
    }

    @GetMapping("/{buyId}")
    public ResponseEntity<BuyResource> getBuyById(@PathVariable Long buyId) {
        var getBuyByIdQuery = new GetBuyByIdQuery(buyId);
        var buy = buyQueryService.handle(getBuyByIdQuery);

        if (buy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var buyResource = BuyResourceFromEntityAssembler.toResourceFromEntity(buy.get());
        return ResponseEntity.ok(buyResource);
    }

    @PutMapping("/{buyId}")
    public ResponseEntity<BuyResource> updateBuy(@PathVariable Long buyId, @RequestBody UpdateBuyResource resource) {
        var updateBuyCommand = UpdateBuyCommandFromResourceAssembler.toCommandFromResource(buyId, resource);
        var updatedBuy = buyCommandService.handle(updateBuyCommand);

        if (updatedBuy.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var buyResource = BuyResourceFromEntityAssembler.toResourceFromEntity(updatedBuy.get());
        return ResponseEntity.ok(buyResource);
    }

    @DeleteMapping("/{buyId}")
    public ResponseEntity<?> deleteBuy(@PathVariable Long buyId) {
        var deleteBuyCommand = new DeleteBuyCommand(buyId);
        buyCommandService.handle(deleteBuyCommand);
        return ResponseEntity.ok("Buy with given id successfully deleted");
    }
}