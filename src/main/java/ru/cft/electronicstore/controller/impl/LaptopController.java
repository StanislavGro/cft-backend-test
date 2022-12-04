package ru.cft.electronicstore.controller.impl;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.Laptop;
import ru.cft.electronicstore.entity.dto.LaptopDto;
import ru.cft.electronicstore.service.impl.LaptopServiceImpl;

@RestController
@RequestMapping("/api/v1/laptop")
@Tag(name = "Laptop", description = "Basic methods for working with laptops")
public class LaptopController extends TechniqueControllerAbs<Laptop, LaptopDto, LaptopServiceImpl> {
    protected LaptopController(LaptopServiceImpl techniqueService) {
        super(techniqueService);
    }
}
