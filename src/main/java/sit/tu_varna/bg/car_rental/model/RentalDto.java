package sit.tu_varna.bg.car_rental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class RentalDto {
    private Long carId;
    private Double price;
    private String customerEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<ExtraDto> extras;
}
