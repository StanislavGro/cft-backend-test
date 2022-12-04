package ru.cft.electronicstore.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.HardDrive;
import ru.cft.electronicstore.entity.dto.HardDriveDto;
import ru.cft.electronicstore.service.impl.HardDriveServiceImpl;

@RestController
@RequestMapping("/api/v1/harddrive")
@Tag(name = "HardDrive", description = "Basic methods for working with hard drives")
public class HardDriveController extends TechniqueControllerAbs<HardDrive, HardDriveDto, HardDriveServiceImpl> {
    protected HardDriveController(HardDriveServiceImpl techniqueService) {
        super(techniqueService);
    }
}
