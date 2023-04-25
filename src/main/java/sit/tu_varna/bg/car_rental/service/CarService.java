package sit.tu_varna.bg.car_rental.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sit.tu_varna.bg.car_rental.data.repository.CarRepository;
import sit.tu_varna.bg.car_rental.model.CarDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarService(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(c -> modelMapper.map(c, CarDto.class)).collect(Collectors.toList());
    }
}
