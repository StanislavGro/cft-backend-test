package ru.cft.electronicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.electronicstore.entity.HardDrive;
import ru.cft.electronicstore.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<HardDrive, Laptop> {
}
