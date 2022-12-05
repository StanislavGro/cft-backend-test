package ru.cft.electronicstore.service.impl;

import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.Monitor;
import ru.cft.electronicstore.entity.dto.MonitorDto;
import ru.cft.electronicstore.repository.MonitorRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorServiceImpl implements TechniqueService<Monitor, MonitorDto> {

    private final MonitorRepository monitorRepository;

    public MonitorServiceImpl(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public void create(Monitor monitor) {
        monitorRepository.save(monitor);
    }

    @Override
    public void update(Long id, MonitorDto monitorDto) {
        Monitor newMonitor = monitorDtoConverter(monitorDto);
        monitorRepository.findById(id)
                .map(monitor -> {
                    monitor.setManufacturer(newMonitor.getManufacturer());
                    monitor.setPriceInRubles(newMonitor.getPriceInRubles());
                    monitor.setDiagonalInCm(newMonitor.getDiagonalInCm());
                    monitor.setSerialNumber(newMonitor.getSerialNumber());
                    monitor.setNumberOfUnits(newMonitor.getNumberOfUnits());
                    return monitorRepository.save(monitor);
                }).orElseGet(() -> {
                    newMonitor.setId(id);
                    return monitorRepository.save(newMonitor);
                });
    }

    @Override
    public void delete(Long id) {
        monitorRepository.deleteById(id);
    }

    @Override
    public List<Monitor> getAll() {
        return monitorRepository.findAll();
    }

    @Override
    public Optional<Monitor> getById(Long id) {
        return monitorRepository.findById(id);
    }

    private Monitor monitorDtoConverter(MonitorDto monitorDto) {
        return new Monitor(monitorDto.getSerialNumber(),
                monitorDto.getManufacturer(),
                monitorDto.getPriceInRubles(),
                monitorDto.getNumberOfUnits(),
                monitorDto.getDiagonalInCm());
    }

}
