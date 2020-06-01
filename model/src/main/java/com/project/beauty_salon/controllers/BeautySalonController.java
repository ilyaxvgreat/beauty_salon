package com.project.beauty_salon.controllers;

import com.project.beauty_salon.domain.BeautySalon;
import com.project.beauty_salon.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/salons", produces = MediaType.APPLICATION_JSON_VALUE)
public class BeautySalonController {
    private final IService<BeautySalon> beautySalonServices;

    @Autowired
    public BeautySalonController(IService<BeautySalon> beautySalonServices) {
        this.beautySalonServices = beautySalonServices;
    }

    @GetMapping
    public String getCats() {
        return "Beauty Salon Page";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeautySalon create(@RequestBody BeautySalon beautySalon){
        return beautySalonServices.create(beautySalon);
    }

    @PutMapping(value = "{id}")
    public BeautySalon editCat(@PathVariable Long id, @RequestBody BeautySalon beautySalon) {
        return beautySalonServices.update(id, beautySalon);
    }

    @GetMapping(value = "/{id}")
    public BeautySalon getCat(@PathVariable Long id) {
        return beautySalonServices.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCat(@PathVariable Long id) {
        beautySalonServices.deleteById(id);
    }
}
