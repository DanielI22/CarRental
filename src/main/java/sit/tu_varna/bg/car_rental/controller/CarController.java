package sit.tu_varna.bg.car_rental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.tu_varna.bg.car_rental.data.entity.Car;
import sit.tu_varna.bg.car_rental.data.repository.CarRepository;
import sit.tu_varna.bg.car_rental.model.CarDto;
import sit.tu_varna.bg.car_rental.service.CarService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }
}
