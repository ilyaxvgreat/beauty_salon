package com.project.beauty_salon.controllers;

import com.project.beauty_salon.domain.SalonService;
import com.project.beauty_salon.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/service", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalonServiceController {
    private final IService<SalonService> salonServiceIService;

    @Autowired
    public SalonServiceController(IService<SalonService> salonServiceIService) {
        this.salonServiceIService = salonServiceIService;
    }

    @GetMapping
    public String hello() {
        return "Salon Service Page";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SalonService create(@RequestBody SalonService salonService){
        return salonServiceIService.create(salonService);
    }


    @PutMapping(value = "{id}")
    public SalonService editCat(@PathVariable Long id, @RequestBody SalonService salonService) {
        return salonServiceIService.update(id, salonService);
    }

    @GetMapping(value = "/{id}")
    public SalonService getCat(@PathVariable Long id) {
        return salonServiceIService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable Long id) {
        salonServiceIService.deleteById(id);
    }
}
