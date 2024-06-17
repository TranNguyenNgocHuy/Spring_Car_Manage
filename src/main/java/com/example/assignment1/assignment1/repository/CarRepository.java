package com.example.assignment1.assignment1.repository;

import com.example.assignment1.assignment1.Dto.CarDto;
import com.example.assignment1.assignment1.entity.Car.Car;
import com.example.assignment1.assignment1.entity.Car.CarId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, CarId> {
}
