package ru.cft.electronicstore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.Laptop;
import ru.cft.electronicstore.entity.dto.LaptopDto;
import ru.cft.electronicstore.exception.ServiceException;
import ru.cft.electronicstore.repository.LaptopRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LaptopServiceImpl implements TechniqueService<Laptop, LaptopDto> {

    private final LaptopRepository laptopRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public void create(Laptop laptop) {
        laptopRepository.save(laptop);
        log.info("Added laptop with id {}", laptop.getId());
    }

    @Override
    public void update(Long id, LaptopDto laptopDto) {
        Laptop newLaptop = laptopDtoConverter(laptopDto);
        laptopRepository.findById(id)
                .map(laptop -> {
                    laptop.setManufacturer(newLaptop.getManufacturer());
                    laptop.setPriceInRubles(newLaptop.getPriceInRubles());
                    laptop.setSerialNumber(newLaptop.getSerialNumber());
                    laptop.setNumberOfUnits(newLaptop.getNumberOfUnits());
                    laptop.setSize(newLaptop.getSize());
                    log.info("Updated laptop with id {}", id);
                    return laptopRepository.save(laptop);
                }).orElseGet(() -> {
                    newLaptop.setId(id);
                    log.info("Didn't find laptop with id {}, so added new laptop", id);
                    return laptopRepository.save(newLaptop);
                });
    }

    @Override
    public void delete(Long id) throws ServiceException {
        checkId(id);
        laptopRepository.deleteById(id);
        log.info("Deleted laptop with id {}", id);
    }

    @Override
    public List<Laptop> getAll() {
        log.info("Gotten all laptops");
        return laptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> getById(Long id) throws ServiceException {
        checkId(id);
        log.info("Gotten laptop with id {}", id);
        return laptopRepository.findById(id);
    }

    public Laptop laptopDtoConverter(LaptopDto laptopDto) {
        return new Laptop(laptopDto.getSerialNumber(),
                laptopDto.getManufacturer(),
                laptopDto.getPriceInRubles(),
                laptopDto.getNumberOfUnits(),
                laptopDto.getSize());
    }

    private void checkId(Long id) throws ServiceException {
        if (!laptopRepository.existsById(id))
            throw new ServiceException(HttpStatus.NOT_FOUND, String.format("Laptop with id %s not found", id));
    }
}
