package sit.tu_varna.bg.car_rental.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.tu_varna.bg.car_rental.data.entity.Rental;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findRentalsByCarId(Long carId);
}
