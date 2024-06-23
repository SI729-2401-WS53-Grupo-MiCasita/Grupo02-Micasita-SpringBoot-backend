package pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.model.queries.GetBuyByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services.BuyCommandService;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.domain.services.BuyQueryService;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.resources.CreateBuyResource;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.resources.BuyResource;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.transform.CreateBuyCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.Transaction.interfaces.rest.transform.BuyResourceFromEntityAssembler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/buys", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Buy", description = "Buy Management Endpoints")
public class BuyController {
    private final BuyCommandService buyCommandService;
    private final BuyQueryService buyQueryService;

    public BuyController(BuyCommandService buyCommandService, BuyQueryService buyQueryService) {
        this.buyCommandService = buyCommandService;
        this.buyQueryService = buyQueryService;
    }
    @PostMapping
    public ResponseEntity<BuyResource> createBuy(@RequestBody CreateBuyResource createBuyResource) {
        var createBuyCommand = CreateBuyCommandFromResourceAssembler.toCommandFromResource(createBuyResource);
        var buyId = buyCommandService.handle(createBuyCommand);

        if (buyId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getBuyByIdQuery = new GetBuyByIdQuery(buyId);
        var buy = buyQueryService.handle(getBuyByIdQuery);

        if (buy.isEmpty())
            return ResponseEntity.badRequest().build();
        var buyResource = BuyResourceFromEntityAssembler.toResourceFromEntity(buy.get());
        return new ResponseEntity<>(buyResource, HttpStatus.CREATED);
    }
}