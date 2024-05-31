package pe.edu.upc.micasita.Micasitaplataform.Micasita.domain.model.entities;

import lombok.*;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "title", nullable = false, length = 50)
  private String title;  

  @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Seller> sellers;
}
