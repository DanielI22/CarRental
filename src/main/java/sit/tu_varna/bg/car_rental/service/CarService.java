package sit.tu_varna.bg.car_rental.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sit.tu_varna.bg.car_rental.data.entity.Car;
import sit.tu_varna.bg.car_rental.data.entity.Extra;
import sit.tu_varna.bg.car_rental.data.entity.Rental;
import sit.tu_varna.bg.car_rental.data.repository.CarRepository;
import sit.tu_varna.bg.car_rental.data.repository.ExtraRepository;
import sit.tu_varna.bg.car_rental.data.repository.RentalRepository;
import sit.tu_varna.bg.car_rental.model.CarDto;
import sit.tu_varna.bg.car_rental.model.RentalDto;
import sit.tu_varna.bg.car_rental.model.RentalInput;
import sit.tu_varna.bg.car_rental.util.Helper;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final RentalRepository rentalRepository;
    private final ExtraRepository extraRepository;
    private final PricingService pricingService;
    private final ModelMapper modelMapper;


    public CarService(CarRepository carRepository, RentalRepository rentalRepository, ExtraRepository extraRepository, PricingService pricingService, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
        this.extraRepository = extraRepository;
        this.pricingService = pricingService;
        this.modelMapper = modelMapper;
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(c -> modelMapper.map(c, CarDto.class)).toList();
    }

    public RentalDto rentACar(RentalInput rentalInput) {
        Car car = carRepository.findById(rentalInput.getCarId()).orElse(null);
        Set<Extra> extras = new HashSet<>(extraRepository.findAllById(rentalInput.getExtrasId()));
        Rental rental = new Rental();
        rental.setCar(car);
        rental.setCustomerEmail(rentalInput.getCustomerEmail());
        rental.setStartDate(rentalInput.getStartDate());
        rental.setEndDate(rentalInput.getEndDate());
        rental.setPrice(pricingService.getRentalFullPrice(rentalInput.getCarId(),
                Long.valueOf(Duration.between(rentalInput.getStartDate(), rentalInput.getStartDate()).toDays()).intValue(),
                rentalInput.getExtrasId()));
        rental.setExtras(extras);
        rentalRepository.save(rental);
        Helper.updateCarRentedDates(car);
        return modelMapper.map(rental, RentalDto.class);
    }
}
