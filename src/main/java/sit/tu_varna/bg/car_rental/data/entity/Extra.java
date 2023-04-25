package sit.tu_varna.bg.car_rental.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;

import java.util.Set;

@Entity
@Table(appliesTo = "extra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraId;
    private String name;
    private Double price;

    @ManyToMany(mappedBy = "extras")
    private Set<Rental> rentals;
}
