package sit.tu_varna.bg.car_rental.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sit.tu_varna.bg.car_rental.data.entity.Car;
import sit.tu_varna.bg.car_rental.data.entity.Rental;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findRentalsByCar(Car car);
}
