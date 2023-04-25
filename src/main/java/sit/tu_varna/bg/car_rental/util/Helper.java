package sit.tu_varna.bg.car_rental.util;

import org.springframework.stereotype.Service;
import sit.tu_varna.bg.car_rental.data.entity.Car;
import sit.tu_varna.bg.car_rental.data.entity.Rental;
import sit.tu_varna.bg.car_rental.data.repository.CarRepository;
import sit.tu_varna.bg.car_rental.data.repository.RentalRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Helper {
    private static RentalRepository rentalRepository;

    public Helper(RentalRepository rentalRepository) {
        Helper.rentalRepository = rentalRepository;
    }

    public static void updateCarRentedDates(Car car) {
        List<Rental> carRentals = rentalRepository.findRentalsByCar(car);
        carRentals.forEach(r -> car.getRentDates().addAll(getDatesBetween(r.getStartDate(), r.getEndDate())));
    }


    private static List<LocalDate> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween + 1)
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toList());
    }
}
