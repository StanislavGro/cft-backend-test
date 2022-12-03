package ru.cft.electronicstore.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.electronicstore.controller.TechniqueController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.dto.ComputerDto;
import ru.cft.electronicstore.service.impl.ComputerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/computer")
public class ComputerController extends TechniqueControllerAbs<Computer, ComputerDto, ComputerServiceImpl> {
    protected ComputerController(ComputerServiceImpl techniqueService) {
        super(techniqueService);
    }
}
