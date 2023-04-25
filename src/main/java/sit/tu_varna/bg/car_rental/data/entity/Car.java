package sit.tu_varna.bg.car_rental.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;
import sit.tu_varna.bg.car_rental.data.repository.CarRepository;

import java.util.Set;

@Entity
@Table(appliesTo = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    private String vinNumber;
    private Double dailyRate;

    @OneToMany(mappedBy = "car")
    private Set<Rental> carRentals;
}
