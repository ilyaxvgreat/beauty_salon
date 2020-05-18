package com.project.beauty_salon.repositories;


import com.project.beauty_salon.domain.BeautySalon;

import java.util.List;

public interface ISalonRepo {
    List<BeautySalon> getAll();

    BeautySalon insert(BeautySalon salon);

    BeautySalon getById(Long id);

    BeautySalon update(Long id, BeautySalon salon);

    void deleteById(Long id);
}
