package com.example.assignment1.assignment1.service;

import com.example.assignment1.assignment1.Dto.AccessoryDto;
import com.example.assignment1.assignment1.Dto.CarDto;

import java.util.List;

public interface AccessoryService extends BaseService<AccessoryDto> {
    List<AccessoryDto> findAllAccessoryByCarId (String licensePlate, String repairDate);

    AccessoryDto create(AccessoryDto accessoryDto);
}
