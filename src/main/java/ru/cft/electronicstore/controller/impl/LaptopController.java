package ru.cft.electronicstore.controller.impl;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.Laptop;
import ru.cft.electronicstore.entity.dto.LaptopDto;
import ru.cft.electronicstore.service.impl.LaptopServiceImpl;

@RestController
@RequestMapping("/api/v1/laptop")
public class LaptopController extends TechniqueControllerAbs<Laptop, LaptopDto, LaptopServiceImpl> {
    protected LaptopController(LaptopServiceImpl techniqueService) {
        super(techniqueService);
    }
}
