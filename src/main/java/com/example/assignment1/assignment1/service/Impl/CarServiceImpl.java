package com.example.assignment1.assignment1.service.Impl;

import com.example.assignment1.assignment1.Dto.CarDto;
import com.example.assignment1.assignment1.entity.Car.Car;
import com.example.assignment1.assignment1.entity.Car.CarId;
import com.example.assignment1.assignment1.repository.CarRepository;
import com.example.assignment1.assignment1.service.CarService;
import com.example.assignment1.assignment1.utils.ParserLocalDate;
import lombok.extern.slf4j.Slf4j;
import com.example.assignment1.assignment1.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository repository;

    @Autowired
    CarMapper mapper;

    @Autowired
    ParserLocalDate parser;


    @Override
    public CarDto create(CarDto carDto) {
        try {
            CarId carId = new CarId(carDto.getLicensePlate(), parser.stringToLocalDate(carDto.getRepairDate()));
            Car car = mapper.convertDTOToEntity(carDto);
            car.setCarId(carId);
            return mapper.convertEntityToDTO(repository.save(car));
        } catch (Exception e) {
            log.error("Error when creating price: " + e);
            return null;
        }
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> carList = repository.findAll();

        System.out.println(carList);
        return carList == null ? new ArrayList<>()
                : carList.stream().map(car -> mapper.convertCarToDto(car))
                .collect(Collectors.toList());
    }
}
