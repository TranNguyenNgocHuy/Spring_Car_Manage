package com.example.assignment1.assignment1.Dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessoryDto extends BaseObject{

    private Long id;

    @NotEmpty (message = "You must enter this Name Accessory field.")
    private String nameAccessory;

    private BigDecimal price;

    private String statusDamaged;

    private String repairStatus;

    private String licensePlate;

    private String repairDate;
}
