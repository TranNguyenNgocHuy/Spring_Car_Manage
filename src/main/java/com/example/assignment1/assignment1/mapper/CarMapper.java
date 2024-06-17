package com.example.assignment1.assignment1.mapper;

import com.example.assignment1.assignment1.Dto.CarDto;
import com.example.assignment1.assignment1.entity.Car.Car;
import org.springframework.stereotype.Service;

@Service
public class CarMapper extends AbstractMapper<Car, CarDto> {
    public CarMapper() {
        super(Car.class, CarDto.class);
    }

    public CarDto convertCarToDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setLicensePlate(car.getCarId().getLicensePlate());
        carDto.setRepairDate(car.getCarId().getRepairDate().toString());
        carDto.setCustomerName(car.getCustomerName());
        carDto.setCatalogs(car.getCatalogs());
        carDto.setCarMaker(car.getCarMaker());
        return carDto;
    }
}
