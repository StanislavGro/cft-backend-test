package ru.cft.electronicstore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.dto.ComputerDto;
import ru.cft.electronicstore.exception.ServiceException;
import ru.cft.electronicstore.repository.ComputerRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ComputerServiceImpl implements TechniqueService<Computer, ComputerDto> {

    private final ComputerRepository computerRepository;

    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public void create(Computer computer) {
        computerRepository.save(computer);
        log.info("Added computer with id {}", computer.getId());
    }

    @Override
    public void update(Long id, ComputerDto computerDto) {
        Computer newComputer = computerDtoConverter(computerDto);
        computerRepository.findById(id)
                .map(computer -> {
                    computer.setPriceInRubles(newComputer.getPriceInRubles());
                    computer.setManufacturer(newComputer.getManufacturer());
                    computer.setSerialNumber(newComputer.getSerialNumber());
                    computer.setNumberOfUnits(newComputer.getNumberOfUnits());
                    computer.setFormFactor(newComputer.getFormFactor());
                    log.info("Updated computer with id {}", id);
                    return computerRepository.save(computer);
                })
                .orElseGet(() -> {
                    newComputer.setId(id);
                    log.info("Didn't find computer with id {}, so added new computer", id);
                    return computerRepository.save(newComputer);
                });

    }

    @Override
    public void delete(Long id) throws ServiceException {
        checkId(id);
        computerRepository.deleteById(id);
        log.info("Deleted computer with id {}", id);
    }

    @Override
    public List<Computer> getAll() {
        log.info("Gotten all computers");
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> getById(Long id) throws ServiceException {
        checkId(id);
        log.info("Gotten computer with id {}", id);
        return computerRepository.findById(id);
    }

    private Computer computerDtoConverter(ComputerDto computerDto) {
        return new Computer(computerDto.getSerialNumber(),
                computerDto.getManufacturer(),
                computerDto.getPriceInRubles(),
                computerDto.getNumberOfUnits(),
                computerDto.getFormFactor());
    }

    private void checkId(Long id) throws ServiceException {
        if (!computerRepository.existsById(id))
            throw new ServiceException(HttpStatus.NOT_FOUND, String.format("Computer with id %s not found", id));
    }
}
