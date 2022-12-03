package ru.cft.electronicstore.service.impl;

import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.Laptop;
import ru.cft.electronicstore.entity.dto.LaptopDto;
import ru.cft.electronicstore.repository.LaptopRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements TechniqueService<Laptop, LaptopDto> {

    private final LaptopRepository laptopRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public void create(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    @Override
    public void update(Long id, LaptopDto laptopDto) {
        Laptop newLaptop = laptopDtoConverter(laptopDto);
        laptopRepository.findById(id)
                .map(laptop -> {
                    laptop.setManufacturer(newLaptop.getManufacturer());
                    laptop.setPrice(newLaptop.getPrice());
                    laptop.setSerialNumber(newLaptop.getSerialNumber());
                    laptop.setNumberOfUnits(newLaptop.getNumberOfUnits());
                    laptop.setSize(newLaptop.getSize());
                    return laptopRepository.save(laptop);
                }).orElseGet(() -> {
                    newLaptop.setId(id);
                    return laptopRepository.save(newLaptop);
                });
    }

    @Override
    public void delete(Long id) {
        laptopRepository.deleteById(id);
    }

    @Override
    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Optional<Laptop> getById(Long id) {
        return laptopRepository.findById(id);
    }

    public Laptop laptopDtoConverter(LaptopDto laptopDto){
        return new Laptop(laptopDto.getSerialNumber(),
                laptopDto.getManufacturer(),
                laptopDto.getPrice(),
                laptopDto.getNumberOfUnits(),
                laptopDto.getSize());
    }
}
