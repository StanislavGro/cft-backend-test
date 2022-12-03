package ru.cft.electronicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.electronicstore.entity.HardDrive;

@Repository
public interface HardDriveRepository extends TechniqueRepository<HardDrive> {
}
