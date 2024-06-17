package com.example.assignment1.assignment1.controller;

import com.example.assignment1.assignment1.Dto.CarDto;
import com.example.assignment1.assignment1.consts.ApiPath;
import com.example.assignment1.assignment1.service.CarService;
import com.example.assignment1.assignment1.utils.ParserLocalDate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class CarController {
    @Autowired
    CarService service;

    @GetMapping("/car")
    public String carPage(Model model) {
        CarDto carDto = new CarDto();
        model.addAttribute("carDto", carDto);
        model.addAttribute("error", false);
        model.addAttribute("success", false);
        return "car";
    }

    @PostMapping(value = ApiPath.CAR_CREATE)
    public String createCar(
            @Valid @ModelAttribute CarDto carDto,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {
            return "car";
        }
        CarDto createCar = service.create(carDto);
        if (createCar == null) {
            model.addAttribute("error", true);
        }
        if (createCar != null) {
            // Save property licensePlate to model then pass through to Accessory detail
            model.addAttribute("licensePlate");
            model.addAttribute("repairDate");
            model.addAttribute("success", true);
        }
        return "car";
    }

    @GetMapping(value = ApiPath.CAR_GET_ALL)
    public String getAllCar(Model model) {

        List<CarDto> carList = service.findAll();
        model.addAttribute("cars", carList);
        return "carList";
    }
}
