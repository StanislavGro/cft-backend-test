package ru.cft.electronicstore.service.impl;

import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.HardDrive;
import ru.cft.electronicstore.entity.dto.HardDriveDto;
import ru.cft.electronicstore.repository.HardDriveRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
public class HardDriveServiceImpl implements TechniqueService<HardDrive, HardDriveDto> {

    private final HardDriveRepository hardDriveRepository;

    public HardDriveServiceImpl(HardDriveRepository hardDriveRepository) {
        this.hardDriveRepository = hardDriveRepository;
    }

    @Override
    public void create(HardDrive hardDrive) {
        hardDriveRepository.save(hardDrive);
    }

    @Override
    public void update(Long id, HardDriveDto hardDriveDto) {
        HardDrive newHardDrive = hardDriveDtoConverter(hardDriveDto);
        hardDriveRepository.findById(id)
                .map(hardDrive -> {
                    hardDrive.setManufacturer(newHardDrive.getManufacturer());
                    hardDrive.setPriceInRubles(newHardDrive.getPriceInRubles());
                    hardDrive.setSerialNumber(newHardDrive.getSerialNumber());
                    hardDrive.setNumberOfUnits(hardDrive.getNumberOfUnits());
                    hardDrive.setVolumeInBits(newHardDrive.getVolumeInBits());
                    return hardDriveRepository.save(hardDrive);
                }).orElseGet(() -> {
                    newHardDrive.setId(id);
                    return hardDriveRepository.save(newHardDrive);
                });
    }

    @Override
    public void delete(Long id) {
        hardDriveRepository.deleteById(id);
    }

    @Override
    public List<HardDrive> getAll() {
        return hardDriveRepository.findAll();
    }

    @Override
    public Optional<HardDrive> getById(Long id) {
        return hardDriveRepository.findById(id);
    }

    private HardDrive hardDriveDtoConverter(HardDriveDto hardDriveDto) {
        return new HardDrive(hardDriveDto.getSerialNumber(),
                hardDriveDto.getManufacturer(),
                hardDriveDto.getPriceInRubles(),
                hardDriveDto.getNumberOfUnits(),
                hardDriveDto.getVolumeInBits());
    }
}
