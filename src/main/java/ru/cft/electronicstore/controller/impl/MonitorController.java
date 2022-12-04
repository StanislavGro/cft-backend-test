package ru.cft.electronicstore.controller.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.Monitor;
import ru.cft.electronicstore.entity.dto.MonitorDto;
import ru.cft.electronicstore.service.impl.MonitorServiceImpl;

@RestController
@RequestMapping("/api/v1/monitor")
@Tag(name = "Monitor", description = "Basic methods for working with monitors")
public class MonitorController extends TechniqueControllerAbs<Monitor, MonitorDto, MonitorServiceImpl> {
    protected MonitorController(MonitorServiceImpl techniqueService) {
        super(techniqueService);
    }
}
