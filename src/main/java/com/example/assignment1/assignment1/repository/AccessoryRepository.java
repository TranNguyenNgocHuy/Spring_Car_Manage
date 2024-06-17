package com.example.assignment1.assignment1.repository;

import com.example.assignment1.assignment1.entity.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {
    @Query(value = "SELECT * FROM accessory WHERE license_plate = :licensePlate AND DATE(repair_date) = :repairDate", nativeQuery = true)
    List<Accessory> findAllByCarId(String licensePlate, String repairDate);
}
