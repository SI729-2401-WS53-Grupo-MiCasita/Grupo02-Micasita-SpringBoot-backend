package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
    private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "property_id", nullable = false)
  private Property property;
}
