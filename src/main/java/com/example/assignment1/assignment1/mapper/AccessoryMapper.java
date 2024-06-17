package com.example.assignment1.assignment1.mapper;

import com.example.assignment1.assignment1.Dto.AccessoryDto;
import com.example.assignment1.assignment1.entity.Accessory;
import org.springframework.stereotype.Service;

@Service
public class AccessoryMapper extends AbstractMapper<Accessory, AccessoryDto>{
    public AccessoryMapper() {
        super(Accessory.class, AccessoryDto.class);
    }
}
