package com.project.beauty_salon.services.impl;

import com.project.beauty_salon.domain.BeautySalon;
import com.project.beauty_salon.repositories.exceptions.APIException;
import com.project.beauty_salon.repositories.impl.BeautySalonRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class BeautySalonServicesImplTest {
    @Mock
    private BeautySalonRepoImpl beautySalonRepo;

    @InjectMocks
    private BeautySalonServicesImpl beautySalonServices;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

//    @Test
//    void getAll() {
//
//    }

    @Test
    @DisplayName("When id in not present then exception throws")
    void getByIdWhenIdIsNotPresentThenExceptionThrows() {
        Long wrongId = 1L;
        when(beautySalonRepo.getById(wrongId)).thenReturn(Optional.empty());
        Assertions.assertThrows(APIException.class,
                () -> beautySalonServices.getById(wrongId));
    }

    @Test
    @DisplayName("When id in not present then exception throws")
    void getByIdWhenIdIsPresent() {
        Long goodId = 1L;
        BeautySalon beautySalon = new BeautySalon(1L, "name",
                "adress", true,
                "man", "1",
                10);

        when(beautySalonRepo.getById(goodId)).thenReturn(Optional.of(beautySalon));
        BeautySalon actual = beautySalonServices.getById(goodId);
        Assertions.assertEquals(beautySalon.getSalonName(),
                actual.getSalonName());
    }

    @Test
    void deleteById() {
        Long id = 1L;
        when(beautySalonRepo.getById(id)).thenReturn(Optional.of(new BeautySalon()));
        doNothing().when(beautySalonRepo).deleteById(id);

        beautySalonServices.deleteById(id);

        verify(beautySalonRepo).deleteById(id);
    }

    @Test
    void create() {
        BeautySalon salon = new BeautySalon(1L, "name",
                "adress", true,
                "man", "1", 1);
        BeautySalon newSalon = new BeautySalon(1L, "name",
                "adress", true,
                "man", "1", 1);
        when(beautySalonRepo.create(salon)).thenReturn(Optional.of(newSalon));

        BeautySalon actualSalon = beautySalonServices.create(salon);

        Assertions.assertNotNull(actualSalon.getId());
    }

    @Test
    void update() {
        Long lastId = 1L;
        Long newId = 2L;
        BeautySalon salon = new BeautySalon(lastId, "name",
                "adress", true,
                "man", "1", 1);

        BeautySalon salonNew = new BeautySalon(newId, "name",
                "adress", true,
                "man", "1", 1);

        when(beautySalonRepo.update(newId,salon)).thenReturn(Optional.of(salonNew));
        BeautySalon nesSalonWithNewId = beautySalonServices.update(newId, salon);

        Assertions.assertEquals(newId, nesSalonWithNewId.getId());
    }
}