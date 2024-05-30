package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.aggregates.VisitRepository;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.Visit;

@Service
public class VisitService {
  private final VisitRepository visitRepository;

  public VisitService(VisitRepository visitRepository) {
    this.visitRepository = visitRepository;
  }

  public List<Visit> getAllVisits() {
    return visitRepository.findAll();
  }
  
  public Visit getVisitById(Integer id) {
    return visitRepository.findById(id).orElse(null);
  }

  public Visit creaVisit(Visit visit) {
    return visitRepository.save(visit);
  }

  public Visit updateVisit(Integer id, Visit visitDetails) {
    Visit visit = visitRepository.findById(id).orElse(null);
    if (visit != null) {
      visit.setDateTime(visitDetails.getDateTime());
      visit.setProperty(visitDetails.getProperty());
      visit.setStatus(visitDetails.getStatus());
      visit.setUser(visitDetails.getUser());
      return visitRepository.save(visit);
    }
    return null;
  }

  public void deleteVisit(Integer id) {
    visitRepository.deleteById(id);
  }
}
