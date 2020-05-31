package com.project.beauty_salon.services;

import java.util.List;

public interface IService<T> {
    List<T> getAll();

    T getById(Long id);

    void deleteById(Long id);

    T create(T t);

    T update(Long id, T t);
}
