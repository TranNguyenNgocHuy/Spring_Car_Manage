package com.example.assignment1.assignment1.Dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarDto extends BaseObject{

    @NotEmpty(message = "You must enter this License Plate field.")
    private String licensePlate;

    @NotEmpty(message = "You must enter this Repair Date field.")
    private String repairDate;

    @NotEmpty(message = "You must enter this Customer Name field.")
    private String customerName;

    private String catalogs;

    private String carMaker;
}
