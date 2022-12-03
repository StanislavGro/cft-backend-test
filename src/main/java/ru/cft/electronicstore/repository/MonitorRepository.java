package ru.cft.electronicstore.repository;

import org.springframework.stereotype.Repository;
import ru.cft.electronicstore.entity.Monitor;

@Repository
public interface MonitorRepository extends TechniqueRepository<Monitor> {
}
