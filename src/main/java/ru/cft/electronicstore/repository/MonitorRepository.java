package ru.cft.electronicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.electronicstore.entity.Monitor;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
