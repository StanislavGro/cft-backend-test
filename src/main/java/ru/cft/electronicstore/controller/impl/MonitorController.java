package ru.cft.electronicstore.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.electronicstore.controller.TechniqueControllerAbs;
import ru.cft.electronicstore.entity.Monitor;
import ru.cft.electronicstore.entity.dto.MonitorDto;
import ru.cft.electronicstore.service.impl.MonitorServiceImpl;

@RestController
@RequestMapping("/api/v1/monitor")
public class MonitorController extends TechniqueControllerAbs<Monitor, MonitorDto, MonitorServiceImpl> {
    protected MonitorController(MonitorServiceImpl techniqueService) {
        super(techniqueService);
    }
}
