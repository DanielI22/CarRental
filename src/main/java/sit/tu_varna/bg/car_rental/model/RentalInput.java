package sit.tu_varna.bg.car_rental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class RentalInput {
    private Long carId;
    private List<Long> extrasId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerEmail;
}
