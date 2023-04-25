package sit.tu_varna.bg.car_rental.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sit.tu_varna.bg.car_rental.data.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
