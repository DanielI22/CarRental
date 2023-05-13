package sit.tu_varna.bg.car_rental.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sit.tu_varna.bg.car_rental.data.entity.Car;
import sit.tu_varna.bg.car_rental.data.entity.Rental;
import sit.tu_varna.bg.car_rental.data.repository.CarRepository;
import sit.tu_varna.bg.car_rental.data.repository.RentalRepository;
import sit.tu_varna.bg.car_rental.model.CarDto;
import sit.tu_varna.bg.car_rental.model.RentalDto;
import sit.tu_varna.bg.car_rental.util.Helper;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final RentalRepository rentalRepository;
    private final ModelMapper modelMapper;


    public CarService(CarRepository carRepository, RentalRepository rentalRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
        this.modelMapper = modelMapper;
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(c -> modelMapper.map(c, CarDto.class)).toList();
    }

    public RentalDto rentACar(RentalDto rentalDto) {
        Car car = carRepository.findCarByVinNumber(rentalDto.getCarVin()).orElse(null);
        Rental rental = new Rental();
        rental.setCarId(car.getCarId());
        rental.setCustomerEmail(rentalDto.getCustomerEmail());
        rental.setStartDate(rentalDto.getStartDate());
        rental.setEndDate(rentalDto.getEndDate());
        rental.setPrice(rentalDto.getPrice());
        rentalRepository.save(rental);
        Helper.updateCarRentedDates(car);
        return modelMapper.map(rental, RentalDto.class);
    }
}
