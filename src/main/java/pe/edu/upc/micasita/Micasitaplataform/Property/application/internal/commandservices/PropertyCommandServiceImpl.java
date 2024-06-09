package pe.edu.upc.micasita.Micasitaplataform.Property.application.internal.commandservices;


import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.commands.*;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.services.PropertyCommandService;
import pe.edu.upc.micasita.Micasitaplataform.Property.infrastructure.persistence.jpa.repositories.PropertyRepository;

import java.util.Optional;

@Service
public class PropertyCommandServiceImpl implements PropertyCommandService {

    private final PropertyRepository propertyRepository;

    public PropertyCommandServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Integer handle(AddPropertyCommand command) {
        var property = command.property();
        if (propertyRepository.existsByLocation(property.getLocation())) {
            throw new IllegalArgumentException("Ya existe una propiedad con esta ubicación");
        }
        propertyRepository.save(property);
        return property.getId();
    }

    @Override
    public Optional<Properties> handle(UpdatePropertyCommand command) {
        return Optional.ofNullable(propertyRepository.findById(command.id())
                .map(property -> {
                    property.updateInformation(command.propertyDetails());
                    return propertyRepository.save(property);
                })
                .orElseThrow(() -> new IllegalArgumentException("Property does not exist")));
    }

    @Override
    public void handle(DeletePropertyCommand command) {
        if (!propertyRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Property does not exist");
        }
        propertyRepository.deleteById(command.id());
    }

    @Override
    public void handle(ChangePropertyStatusCommand command) {
        propertyRepository.findById(command.id()).map(property -> {
            property.changeStatus(command.status());
            propertyRepository.save(property);
            return property;
        });
    }

    @Override
    public void handle(ChangePropertyPriceCommand command) {
        propertyRepository.findById(command.id()).map(property -> {
            property.changePrice(command.newPrice());
            propertyRepository.save(property);
            return property;
        });
    }

    @Override
    public void handle(ChangePropertyTypeCommand command) {
        propertyRepository.findById(command.id()).map(property -> {
            property.changeType(command.newType());
            propertyRepository.save(property);
            return property;
        });
    }

    @Override
    public void handle(ChangePropertyDescriptionCommand command) {
        propertyRepository.findById(command.id()).map(property -> {
            property.changeDescription(command.newDescription());
            propertyRepository.save(property);
            return property;
        });
    }

    @Override
    public void handle(ChangePropertyLocationCommand command) {
        if (propertyRepository.existsByLocationAndIdIsNot(command.newLocation(), command.id())) {
            throw new IllegalArgumentException("Ya existe otra propiedad con esta ubicación");
        }
        propertyRepository.findById(command.id()).map(property -> {
            property.changeLocation(command.newLocation());
            propertyRepository.save(property);
            return property;
        });
    }
}