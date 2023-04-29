package sit.tu_varna.bg.car_rental.service;

import org.springframework.stereotype.Service;
import sit.tu_varna.bg.car_rental.data.entity.Car;
import sit.tu_varna.bg.car_rental.data.entity.Extra;
import sit.tu_varna.bg.car_rental.data.repository.CarRepository;
import sit.tu_varna.bg.car_rental.data.repository.ExtraRepository;

import java.util.List;

@Service
public class PricingService {
    private final CarRepository carRepository;
    private final ExtraRepository extraRepository;

    public PricingService(CarRepository carRepository, ExtraRepository extraRepository) {
        this.carRepository = carRepository;
        this.extraRepository = extraRepository;
    }

    public Double getRentalFullPrice(Long carId, Integer days, List<Long> extrasId) {
        Car car = carRepository.findById(carId).orElse(null);
        List<Extra> extras = extraRepository.findAllById(extrasId);
        return car.getDailyRate()*days + extras.stream().map(e -> e.getPrice()).reduce(0d, Double::sum);
    }
}
