package com.example.assignment1.assignment1.controller;

import com.example.assignment1.assignment1.Dto.AccessoryDto;
import com.example.assignment1.assignment1.consts.ApiPath;
import com.example.assignment1.assignment1.entity.Accessory;
import com.example.assignment1.assignment1.mapper.AccessoryMapper;
import com.example.assignment1.assignment1.repository.AccessoryRepository;
import com.example.assignment1.assignment1.service.AccessoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class AccessoryController {

    @Autowired
    AccessoryService accessoryService;

    @Autowired
    AccessoryRepository repository;

    @Autowired
    AccessoryMapper mapper;

    @GetMapping("/accessory")
    public String accessoryPage(@RequestParam("licensePlate") String licensePlate,
                                @RequestParam("repairDate") String repairDate,
                                Model model) {
        AccessoryDto accessoryDto = new AccessoryDto();
        model.addAttribute("accessoryDto", accessoryDto);
        model.addAttribute("licensePlate", licensePlate);
        model.addAttribute("repairDate", repairDate);

        List<AccessoryDto> accessoryDtoList = accessoryService.findAllAccessoryByCarId(licensePlate, repairDate);
        model.addAttribute("accessoryList", accessoryDtoList);

        return "accessory";
    }

    @PostMapping(value = ApiPath.ACCESSORY_CREATE)
    public String createAccessory(
            @RequestParam("licensePlate") String licensePlate,
            @RequestParam("repairDate") String repairDate,
            Model model,
            @Valid @ModelAttribute("accessoryDto") AccessoryDto accessoryDto,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            model.addAttribute("licensePlate", licensePlate);
            model.addAttribute("repairDate", repairDate);
            List<AccessoryDto> accessoryDtoList = accessoryService.findAllAccessoryByCarId(licensePlate, repairDate);
            model.addAttribute("accessoryList", accessoryDtoList);
            return "accessory";
        }

        accessoryDto.setLicensePlate(licensePlate);
        accessoryDto.setRepairDate(repairDate);
        accessoryService.create(accessoryDto);

        return "redirect:/accessory?licensePlate=" + licensePlate + "&repairDate=" + repairDate;
    }

    @GetMapping("/accessory/edit")
    public String showEditAccessory(@RequestParam("licensePlate") String licensePlate,
                                    @RequestParam("repairDate") String repairDate,
                                    @RequestParam Long id,
                                    Model model) {
        try {
            model.addAttribute("licensePlate", licensePlate);
            model.addAttribute("repairDate", repairDate);
            AccessoryDto accessoryDto = new AccessoryDto();

            Optional<Accessory> accessoryOptional = repository.findById(id);

            if (accessoryOptional.isPresent()) {
                accessoryDto = mapper.convertEntityToDTO(accessoryOptional.get());
            }
            model.addAttribute("accessoryDto", accessoryDto);
            return "accessoryEdit";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "accessory";
        }
    }

    @PostMapping("/accessory/edit")
    public String updateAccessory(
            @RequestParam("licensePlate") String licensePlate,
            @RequestParam("repairDate") String repairDate,
            @RequestParam("id") Long id,
            AccessoryDto accessoryDto,
            Model model
    ) {

       Optional<Accessory> updateAccessory = repository.findById(id)
               .map(accessory -> {
                   accessory.setNameAccessory(accessoryDto.getNameAccessory());
                   accessory.setPrice(accessoryDto.getPrice());
                   accessory.setStatusDamaged(accessoryDto.getStatusDamaged());
                   accessory.setRepairStatus(accessoryDto.getRepairStatus());
                   return repository.save(accessory);
               });

        model.addAttribute("licensePlate", licensePlate);
        model.addAttribute("repairDate", repairDate);
        model.addAttribute("accessoryDto", accessoryDto);
        return "redirect:/accessory?licensePlate=" + licensePlate + "&repairDate=" + repairDate;
    }

    @GetMapping("/accessory/delete")
    public String deleteAccessory(
            @RequestParam("licensePlate") String licensePlate,
            @RequestParam("repairDate") String repairDate,
            @RequestParam("id") Long id
    ) {
        try{
            Accessory deleteAccessory = repository.findById(id).get();
            repository.delete(deleteAccessory);
            return "redirect:/accessory?licensePlate=" + licensePlate + "&repairDate=" + repairDate;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/accessory?licensePlate=" + licensePlate + "&repairDate=" + repairDate;
        }
    }
}

