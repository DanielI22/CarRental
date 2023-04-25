package sit.tu_varna.bg.car_rental.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(appliesTo = "rental")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;
    private Long carId;
    private Double price;
    private String customerEmail;
    private LocalDate startDate;
    private LocalDate endDate;


    @ManyToOne
    @JoinColumn(name = "carId", insertable = false, updatable = false)
    private Car car;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "rental_extra",
            joinColumns = { @JoinColumn(name = "rentalId") },
            inverseJoinColumns = { @JoinColumn(name = "extraId") }
    )
    Set<Extra> extras;
}
