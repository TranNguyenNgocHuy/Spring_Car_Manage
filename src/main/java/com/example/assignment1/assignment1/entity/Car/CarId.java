package com.example.assignment1.assignment1.entity.Car;

import com.example.assignment1.assignment1.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CarId extends BaseEntity {

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "repair_date")
    private LocalDate repairDate;
}
