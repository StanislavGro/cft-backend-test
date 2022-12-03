package ru.cft.electronicstore.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.dto.ComputerDto;
import ru.cft.electronicstore.service.impl.ComputerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/computer")
public class ComputerController {

    private final ComputerServiceImpl computerService;

    public ComputerController(ComputerServiceImpl computerService) {
        this.computerService = computerService;
    }


}
