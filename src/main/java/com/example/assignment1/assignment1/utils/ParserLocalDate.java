package com.example.assignment1.assignment1.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ParserLocalDate {
    public LocalDate stringToLocalDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate result = LocalDate.parse(date, formatter);
        System.out.println(result);
        return result;
    }
}
