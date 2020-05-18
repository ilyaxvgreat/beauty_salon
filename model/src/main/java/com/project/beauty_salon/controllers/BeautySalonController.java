package com.project.beauty_salon.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pets",produces = MediaType.APPLICATION_JSON_VALUE)
public class BeautySalonController {

    @GetMapping
    public String hello(){
        return "Hello From Beauty Salon";
    }
}
