package pe.edu.upc.micasita.Micasitaplataform.Micasita.application.internal;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities.Visit;
import pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.services.VisitService;

@RestController
@RequestMapping("api/visits")
public class VisitController {
  @Autowired
  private VisitService visitService;

  @GetMapping
  public List<Visit> getAllVisits() {
      return visitService.getAllVisits();
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Visit> getVisitById(@PathVariable Integer id) {
    Visit visit = visitService.getVisitById(id);
    if(visit != null) {
      return ResponseEntity.ok(visit);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public Visit createVisit(@RequestBody Visit visit) {
    return visitService.creaVisit(visit);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Visit> updateVisit(@PathVariable Integer id, @RequestBody Visit visit) {
    Visit updateVisit = visitService.updateVisit(id, visit);
    if(updateVisit != null) {
      return ResponseEntity.ok(updateVisit);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVisit(@PathVariable Integer id) {
    visitService.deleteVisit(id);
    return ResponseEntity.noContent().build();
  }
}
