package ru.cft.electronicstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.cft.electronicstore.entity.Technique;

@NoRepositoryBean
public interface TechniqueRepository<E extends Technique> extends JpaRepository<E, Long> {
}
