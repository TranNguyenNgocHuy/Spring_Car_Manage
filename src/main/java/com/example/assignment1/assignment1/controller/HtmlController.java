package com.example.assignment1.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HtmlController {
    @GetMapping("/")
    public String show() {
        return "home";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

}
