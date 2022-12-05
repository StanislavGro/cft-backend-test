package ru.cft.electronicstore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.Monitor;
import ru.cft.electronicstore.entity.dto.MonitorDto;
import ru.cft.electronicstore.exception.ServiceException;
import ru.cft.electronicstore.repository.MonitorRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MonitorServiceImpl implements TechniqueService<Monitor, MonitorDto> {

    private final MonitorRepository monitorRepository;

    public MonitorServiceImpl(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public void create(Monitor monitor) {
        monitorRepository.save(monitor);
        log.info("Added monitor with id {}", monitor.getId());
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
                    log.info("Updated monitor with id {}", id);
                    return monitorRepository.save(monitor);
                }).orElseGet(() -> {
                    newMonitor.setId(id);
                    log.info("Didn't find monitor with id {}, so added new monitor", id);
                    return monitorRepository.save(newMonitor);
                });
    }

    @Override
    public void delete(Long id) throws ServiceException {
        checkId(id);
        log.info("Deleted monitor with id {}", id);
        monitorRepository.deleteById(id);
    }

    @Override
    public List<Monitor> getAll() {
        log.info("Gotten all monitors");
        return monitorRepository.findAll();
    }

    @Override
    public Optional<Monitor> getById(Long id) throws ServiceException {
        checkId(id);
        log.info("Gotten monitor with id {}", id);
        return monitorRepository.findById(id);
    }

    private Monitor monitorDtoConverter(MonitorDto monitorDto) {
        return new Monitor(monitorDto.getSerialNumber(),
                monitorDto.getManufacturer(),
                monitorDto.getPriceInRubles(),
                monitorDto.getNumberOfUnits(),
                monitorDto.getDiagonalInCm());
    }

    private void checkId(Long id) throws ServiceException {
        if (!monitorRepository.existsById(id))
            throw new ServiceException(HttpStatus.NOT_FOUND, String.format("Monitor with id %s not found", id));
    }

}
