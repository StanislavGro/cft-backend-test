package ru.cft.electronicstore.service;

import ru.cft.electronicstore.entity.Technique;
import ru.cft.electronicstore.entity.dto.TechniqueDto;

import java.util.List;
import java.util.Optional;

public interface TechniqueService<T extends Technique, TDO extends TechniqueDto>{

    void create(T technique);

    void update(Long id, TDO newTechniqueDto);

    void delete(Long id);

    List<T> getAll();

    Optional<T> getById(Long id);
}
