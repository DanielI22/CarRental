package sit.tu_varna.bg.car_rental.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sit.tu_varna.bg.car_rental.data.entity.Extra;

@Repository
public interface ExtraRepository extends JpaRepository<Extra, Long> {
}
