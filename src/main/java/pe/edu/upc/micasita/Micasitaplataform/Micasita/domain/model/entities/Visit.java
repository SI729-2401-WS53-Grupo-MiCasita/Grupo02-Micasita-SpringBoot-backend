package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import lombok.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "visits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "property_id", nullable = false)
  private Property property;

  @Column(name = "date_time", nullable = false)
  private LocalDateTime dateTime;

  @Column(name = "status", nullable = false, length = 15)
  private String status;
}
