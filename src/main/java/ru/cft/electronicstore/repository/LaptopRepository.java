package ru.cft.electronicstore.repository;

import org.springframework.stereotype.Repository;
import ru.cft.electronicstore.entity.Laptop;

@Repository
public interface LaptopRepository extends TechniqueRepository<Laptop> {
}
