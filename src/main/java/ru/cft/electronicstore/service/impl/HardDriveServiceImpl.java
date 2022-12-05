package ru.cft.electronicstore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.cft.electronicstore.entity.HardDrive;
import ru.cft.electronicstore.entity.dto.HardDriveDto;
import ru.cft.electronicstore.exception.ServiceException;
import ru.cft.electronicstore.repository.HardDriveRepository;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HardDriveServiceImpl implements TechniqueService<HardDrive, HardDriveDto> {

    private final HardDriveRepository hardDriveRepository;

    public HardDriveServiceImpl(HardDriveRepository hardDriveRepository) {
        this.hardDriveRepository = hardDriveRepository;
    }

    @Override
    public void create(HardDrive hardDrive) {
        hardDriveRepository.save(hardDrive);
        log.info("Added hard drive with id {}", hardDrive.getId());
    }

    @Override
    public void update(Long id, HardDriveDto hardDriveDto) {
        HardDrive newHardDrive = hardDriveDtoConverter(hardDriveDto);
        hardDriveRepository.findById(id)
                .map(hardDrive -> {
                    hardDrive.setManufacturer(newHardDrive.getManufacturer());
                    hardDrive.setPriceInRubles(newHardDrive.getPriceInRubles());
                    hardDrive.setSerialNumber(newHardDrive.getSerialNumber());
                    hardDrive.setNumberOfUnits(newHardDrive.getNumberOfUnits());
                    hardDrive.setVolumeInBits(newHardDrive.getVolumeInBits());
                    log.info("Updated hard drive with id {}", id);
                    return hardDriveRepository.save(hardDrive);
                }).orElseGet(() -> {
                    newHardDrive.setId(id);
                    log.info("Didn't find hard drive with id {}, so added new hard drive", id);
                    return hardDriveRepository.save(newHardDrive);
                });
    }

    @Override
    public void delete(Long id) throws ServiceException {
        checkId(id);
        hardDriveRepository.deleteById(id);
        log.info("Deleted hard drive with id {}", id);
    }

    @Override
    public List<HardDrive> getAll() {
        log.info("Gotten all hard drives");
        return hardDriveRepository.findAll();
    }

    @Override
    public Optional<HardDrive> getById(Long id) throws ServiceException {
        checkId(id);
        log.info("Gotten hard drive with id {}", id);
        return hardDriveRepository.findById(id);
    }

    private HardDrive hardDriveDtoConverter(HardDriveDto hardDriveDto) {
        return new HardDrive(hardDriveDto.getSerialNumber(),
                hardDriveDto.getManufacturer(),
                hardDriveDto.getPriceInRubles(),
                hardDriveDto.getNumberOfUnits(),
                hardDriveDto.getVolumeInBits());
    }

    private void checkId(Long id) throws ServiceException {
        if (!hardDriveRepository.existsById(id))
            throw new ServiceException(HttpStatus.NOT_FOUND, String.format("Hard drive with id %s not found", id));
    }
}
