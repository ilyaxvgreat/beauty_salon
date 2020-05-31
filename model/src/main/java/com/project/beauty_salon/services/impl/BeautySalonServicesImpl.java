package com.project.beauty_salon.services.impl;

import com.project.beauty_salon.domain.BeautySalon;
import com.project.beauty_salon.repositories.IRepository;
import com.project.beauty_salon.repositories.exceptions.APIException;
import com.project.beauty_salon.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeautySalonServicesImpl implements IService<BeautySalon> {
    private final IRepository<BeautySalon> beautySalonRepo;

    @Autowired
    public BeautySalonServicesImpl(IRepository<BeautySalon> beautySalonRepo) {
        this.beautySalonRepo = beautySalonRepo;
    }


    @Override
    public List<BeautySalon> getAll() {
        return beautySalonRepo.getAll();
    }

    @Override
    public BeautySalon getById(Long id) {
        var salon = beautySalonRepo.getById(id);
        if(salon.isEmpty()){
            throw new APIException();
        }
        return salon.get();
    }

    @Override
    public void deleteById(Long id) {
        beautySalonRepo.deleteById(id);
    }

    @Override
    public BeautySalon create(BeautySalon beautySalon) {
        var salon = beautySalonRepo.getById(beautySalon.getId());
        if (salon.isPresent()){
            throw new APIException();
        }
        return beautySalonRepo.create(beautySalon).get();
    }

    @Override
    public BeautySalon update(Long id, BeautySalon beautySalon) {
        return beautySalonRepo.update(id, beautySalon).get();
    }
}
