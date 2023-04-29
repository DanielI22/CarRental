package sit.tu_varna.bg.car_rental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class CarDto {
    private String vinNumber;
    private Double dailyRate;
    private List<LocalDate> rentDates;
    private String imageUrl;
    private String fuelType;
}
