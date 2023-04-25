package sit.tu_varna.bg.car_rental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class CarDto {
    private String vinNumber;
    private Double dailyRate;
}
