package ru.cft.electronicstore.service.impl;

import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.dto.ComputerDto;
import ru.cft.electronicstore.repository.ComputerRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServiceImpl implements TechniqueService<Computer, ComputerDto> {

    private final ComputerRepository computerRepository;

    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public void create(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public void update(Long id, ComputerDto computerDto) {
        Computer newComputer = ComputerDtoConverter(computerDto);
        computerRepository.findById(id)
                .map(computer -> {
                    computer.setPriceInRubles(newComputer.getPriceInRubles());
                    computer.setManufacturer(newComputer.getManufacturer());
                    computer.setSerialNumber(newComputer.getSerialNumber());
                    computer.setNumberOfUnits(newComputer.getNumberOfUnits());
                    computer.setFormFactor(newComputer.getFormFactor());
                    return computerRepository.save(computer);
                })
                .orElseGet(() -> {
                    newComputer.setId(id);
                    return computerRepository.save(newComputer);
                });
    }

    @Override
    public void delete(Long id) {
        computerRepository.deleteById(id);
    }

    @Override
    public List<Computer> getAll() {
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> getById(Long id) {
        return computerRepository.findById(id);
    }

    private Computer ComputerDtoConverter(ComputerDto computerDto) {
        return new Computer(computerDto.getSerialNumber(),
                computerDto.getManufacturer(),
                computerDto.getPriceInRubles(),
                computerDto.getNumberOfUnits(),
                computerDto.getFormFactor());
    }
}
