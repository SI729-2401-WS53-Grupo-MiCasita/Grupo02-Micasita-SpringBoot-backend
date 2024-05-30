package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.PropertyImages;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Price;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.valueobjects.Status;

import java.math.BigDecimal;
import java.util.List;

public interface Properties {
    Integer getId();
    void setId(Integer id);

    String getTitle();
    void setTitle(String title);

    String getDescription();
    void setDescription(String description);

    Price getPrice();
    void setPrice(Price price);

    String getLocation();
    void setLocation(String location);

    Status getStatus();
    void setStatus(Status status);

    String getType();
    void setType(String type);

    BigDecimal getSize();
    void setSize(BigDecimal size);

    Integer getBedrooms();
    void setBedrooms(Integer bedrooms);

    Integer getBathrooms();
    void setBathrooms(Integer bathrooms);

    Integer getGarageSpace();
    void setGarageSpace(Integer garageSpace);

    Integer getYearBuilt();
    void setYearBuilt(Integer yearBuilt);

    List<PropertyImages> getImages();
    void setImages(List<PropertyImages> images);
}
