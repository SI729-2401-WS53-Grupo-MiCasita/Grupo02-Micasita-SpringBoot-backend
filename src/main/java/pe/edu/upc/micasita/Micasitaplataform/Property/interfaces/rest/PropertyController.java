package pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.AddPropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.DeletePropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.UpdatePropertyCommand;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries.GetAllPropertiesQuery;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.queries.GetPropertyByIdQuery;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.services.PropertyCommandService;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.services.PropertyQueryService;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.CreatePropertyResource;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.DeletePropertyResource;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.PropertyResource;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.resources.UpdatePropertyResource;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform.CreatePropertyCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform.DeletePropertyCommandFromResourceAssembler;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform.PropertyResourceFromEntityAssembler;
import pe.edu.upc.micasita.Micasitaplataform.Property.interfaces.rest.transform.UpdatePropertyCommandFromResourceAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/properties", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Properties", description = "Property Management Endpoints")
public class PropertyController {
    private final PropertyCommandService propertyCommandService;
    private final PropertyQueryService propertyQueryService;

    public PropertyController(PropertyCommandService propertyCommandService, PropertyQueryService propertyQueryService) {
        this.propertyCommandService = propertyCommandService;
        this.propertyQueryService = propertyQueryService;
    }
    //Get Property by ID
    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyResource> getPropertyById(@PathVariable Integer propertyId) {
        var getPropertyByIdQuery = new GetPropertyByIdQuery(propertyId);
        var property = propertyQueryService.handle(getPropertyByIdQuery);
        if (property.isEmpty())
            return ResponseEntity.badRequest().build();
        var propertyResource = PropertyResourceFromEntityAssembler.toResourceFromEntity(property.get());
        return ResponseEntity.ok(propertyResource);
    }
    //Get Property all Properties
    @GetMapping
    public ResponseEntity<List<PropertyResource>> getAllProperties() {
        var getAllPropertiesQuery = new GetAllPropertiesQuery();
        var properties = propertyQueryService.handle(getAllPropertiesQuery);
        var propertyResources = properties.stream()
                .map(PropertyResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(propertyResources);
    }
    //Add Property
    @PostMapping
    public ResponseEntity<Void> addProperty(@RequestBody CreatePropertyResource resource) {
        AddPropertyCommand addPropertyCommand = CreatePropertyCommandFromResourceAssembler.toCommandFromResource(resource);
        propertyCommandService.handle(addPropertyCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //Update Property
    @PutMapping("/{propertyId}")
    public ResponseEntity<Void> updateProperty(@PathVariable Long propertyId, @RequestBody UpdatePropertyResource resource) {
        UpdatePropertyCommand updatePropertyCommand = UpdatePropertyCommandFromResourceAssembler.toCommandFromResource(resource);
        propertyCommandService.handle(updatePropertyCommand);
        return ResponseEntity.ok().build();
    }
    //Delete Property
    @DeleteMapping("/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId, @RequestBody DeletePropertyResource resource) {
        DeletePropertyCommand deletePropertyCommand = DeletePropertyCommandFromResourceAssembler.toCommandFromResource(resource);
        propertyCommandService.handle(deletePropertyCommand);
        return ResponseEntity.ok().build();
    }
}