package com.example.assignment1.assignment1.entity.Car;


import com.example.assignment1.assignment1.entity.Accessory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @EmbeddedId
    private CarId carId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "catalogs")
    private String catalogs;

    @Column(name = "car_marker")
    private String carMaker;
}
