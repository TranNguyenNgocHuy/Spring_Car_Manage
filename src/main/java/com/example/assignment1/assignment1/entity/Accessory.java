package com.example.assignment1.assignment1.entity;


import com.example.assignment1.assignment1.entity.Car.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accessory")
public class Accessory extends BaseEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column
    private String nameAccessory;

    @Column
    private BigDecimal price;

    @Column
    private String statusDamaged;

    @Column
    private String repairStatus;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "license_plate", referencedColumnName = "license_plate"),
            @JoinColumn(name = "repair_date", referencedColumnName = "repair_date")
    })
    private Car car;
}
