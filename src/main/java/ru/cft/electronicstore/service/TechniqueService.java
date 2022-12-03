package ru.cft.electronicstore.service;

import ru.cft.electronicstore.entity.Technique;

import java.util.List;
import java.util.Optional;

public interface TechniqueService<T extends Technique>{

    void create(T technique);

    void update(Long id, T newTechnique);

    void delete(Long id);

    List<T> getAll();

    Optional<T> getById(Long id);
}
