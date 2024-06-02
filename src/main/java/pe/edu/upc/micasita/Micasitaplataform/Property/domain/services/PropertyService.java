package pe.edu.upc.micasita.Micasitaplataform.Property.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micasita.Micasitaplataform.Property.domain.model.aggregate.Properties;
import pe.edu.upc.micasita.Micasitaplataform.Property.repository.PropertyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    private final PropertyRepository repository;

    @Autowired
    public PropertyService(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<Properties> findAll() {
        return repository.findAll();
    }

    public Optional<Properties> findById(Integer id) {
        return repository.findById(id);
    }

    public Properties save(Properties property) {
        return repository.save(property);
    }
    public Properties updateProperty(Integer id, Properties propertyDetails) {
        Properties property = repository.findById(id).orElse(null);
        if (property != null) {
            property.setTitle(propertyDetails.getTitle());
            property.setDescription(propertyDetails.getDescription());
            property.setPrice(propertyDetails.getPrice());
            property.setLocation(propertyDetails.getLocation());
            property.setStatus(propertyDetails.getStatus());
            property.setType(propertyDetails.getType());
            property.setSize(propertyDetails.getSize());
            property.setBedrooms(propertyDetails.getBedrooms());
            property.setBathrooms(propertyDetails.getBathrooms());
            property.setGarageSpace(propertyDetails.getGarageSpace());
            property.setYearBuilt(propertyDetails.getYearBuilt());
            property.setSellerID(propertyDetails.getSellerID());

            return repository.save(property);
        } else {
            return null;
        }
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}