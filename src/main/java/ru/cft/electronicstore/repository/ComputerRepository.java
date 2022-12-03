package ru.cft.electronicstore.repository;

import org.springframework.stereotype.Repository;
import ru.cft.electronicstore.entity.Computer;

@Repository
public interface ComputerRepository extends TechniqueRepository<Computer> {
}
