package ru.cft.electronicstore.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.electronicstore.controller.TechniqueController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.HardDrive;
import ru.cft.electronicstore.entity.dto.HardDriveDto;
import ru.cft.electronicstore.service.impl.HardDriveServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/harddrive")
public class HardDriveController extends TechniqueControllerAbs<HardDrive, HardDriveDto, HardDriveServiceImpl> {
    protected HardDriveController(HardDriveServiceImpl techniqueService) {
        super(techniqueService);
    }
}
