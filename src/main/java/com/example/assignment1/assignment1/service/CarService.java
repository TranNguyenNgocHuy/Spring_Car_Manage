package com.example.assignment1.assignment1.service;

import com.example.assignment1.assignment1.Dto.CarDto;

import java.util.List;

public interface CarService extends BaseService<CarDto> {
    CarDto create(CarDto carDto);

    List<CarDto> findAll();
}
