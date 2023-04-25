package sit.tu_varna.bg.car_rental.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.tu_varna.bg.car_rental.data.entity.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
