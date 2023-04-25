package sit.tu_varna.bg.car_rental.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.Type;
import sit.tu_varna.bg.car_rental.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Column(length = 9000)
    private String imageUrl;

    @OneToMany(mappedBy = "car")
    private Set<Rental> carRentals;

    @Transient
    private List<LocalDate> rentDates = new ArrayList<>();

    @PostLoad
    private void onLoad() {
        Helper.updateCarRentedDates(this);
    }
}
