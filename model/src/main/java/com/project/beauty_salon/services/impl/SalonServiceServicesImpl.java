package com.project.beauty_salon.services.impl;

import com.project.beauty_salon.domain.SalonService;
import com.project.beauty_salon.repositories.IRepository;
import com.project.beauty_salon.repositories.exceptions.APIException;
import com.project.beauty_salon.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceServicesImpl implements IService<SalonService> {
    private final IRepository<SalonService> salonServiceRepo;

    @Autowired
    public SalonServiceServicesImpl(IRepository<SalonService> salonServiceRepo) {
        this.salonServiceRepo = salonServiceRepo;
    }

    @Override
    public List<SalonService> getAll() {
        return salonServiceRepo.getAll();
    }

    @Override
    public SalonService getById(Long id) {
        var salonService = salonServiceRepo.getById(id);
        if (salonService.isEmpty()) {
            throw new APIException();
        }
        return salonService.get();
    }

    @Override
    public void deleteById(Long id) {
        salonServiceRepo.deleteById(id);
    }

    @Override
    public SalonService create(SalonService salonService) {
        var salonServ = salonServiceRepo.getById(salonService.getId());
        if (salonServ.isPresent()) {
            throw new APIException();
        }
        return salonServiceRepo.create(salonService).get();
    }

    @Override
    public SalonService update(Long id, SalonService salonService) {
        return salonServiceRepo.update(id, salonService).get();
    }

}

