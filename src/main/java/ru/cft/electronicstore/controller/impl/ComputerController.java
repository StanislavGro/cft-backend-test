package ru.cft.electronicstore.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.dto.ComputerDto;
import ru.cft.electronicstore.service.impl.ComputerServiceImpl;

@RestController
@RequestMapping("/api/v1/computer")
@Tag(name = "Computer", description = "Basic methods for working with computers")
public class ComputerController extends TechniqueControllerAbs<Computer, ComputerDto, ComputerServiceImpl> {
    protected ComputerController(ComputerServiceImpl techniqueService) {
        super(techniqueService);
    }
}
