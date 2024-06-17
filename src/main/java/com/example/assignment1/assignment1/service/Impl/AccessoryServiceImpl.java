package com.example.assignment1.assignment1.service.Impl;

import com.example.assignment1.assignment1.Dto.AccessoryDto;
import com.example.assignment1.assignment1.entity.Accessory;
import com.example.assignment1.assignment1.entity.Car.Car;
import com.example.assignment1.assignment1.entity.Car.CarId;
import com.example.assignment1.assignment1.mapper.AccessoryMapper;
import com.example.assignment1.assignment1.repository.AccessoryRepository;
import com.example.assignment1.assignment1.repository.CarRepository;
import com.example.assignment1.assignment1.service.AccessoryService;
import com.example.assignment1.assignment1.utils.ParserLocalDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    AccessoryRepository accessoryRepository;

    @Autowired
    ParserLocalDate parser;

    @Autowired
    AccessoryMapper mapper;

    @Override
    public AccessoryDto create(AccessoryDto accessoryDto) {
        try {
            LocalDate localDate = parser.stringToLocalDate(accessoryDto.getRepairDate());
            CarId carId = new CarId(accessoryDto.getLicensePlate(), localDate);

            Accessory accessory = accessoryRepository.save(mapper.convertDTOToEntity(accessoryDto));
            accessory.setCar(carRepository.findById(carId).get());

            return mapper.convertEntityToDTO(accessoryRepository.save(accessory));
        } catch (Exception e) {
            log.error("Error when creating price: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<AccessoryDto> findAllAccessoryByCarId (String licensePlate, String repairDate) {
        List<Accessory> accessoryList = accessoryRepository.findAllByCarId(licensePlate, repairDate);
        return accessoryList == null ? new ArrayList<>():
                accessoryList.stream().map(entity -> mapper.convertEntityToDTO(entity))
                        .collect(Collectors.toList());
    }
}
