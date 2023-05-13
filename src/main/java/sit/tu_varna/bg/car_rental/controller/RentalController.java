package sit.tu_varna.bg.car_rental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sit.tu_varna.bg.car_rental.model.RentalDto;
import sit.tu_varna.bg.car_rental.service.CarService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RentalController {
    private final CarService carService;

    public RentalController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/rent")
    public ResponseEntity<RentalDto> rentCar(@RequestBody RentalDto rentalDto) {
            return ResponseEntity.ok(carService.rentACar(rentalDto));
    }
}
