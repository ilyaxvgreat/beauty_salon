package com.project.beauty_salon.repositories;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    List<T> getAll();

    Optional<T> create(T t);

    Optional<T> getById(Long id);

    Optional<T> update(Long id, T t);

    void deleteById(Long id);
}
