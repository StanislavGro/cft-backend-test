package ru.cft.electronicstore.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.electronicstore.entity.HardDrive;
import ru.cft.electronicstore.entity.dto.HardDriveDto;
import ru.cft.electronicstore.service.impl.HardDriveServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/harddrive")
public class HardDriveController {

    private final HardDriveServiceImpl hardDriveService;

    public HardDriveController(HardDriveServiceImpl hardDriveService) {
        this.hardDriveService = hardDriveService;
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    public ResponseEntity<List<HardDrive>> getAllHardDrives() {
        return ResponseEntity.ok(hardDriveService.getAll());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<HardDrive> getHardDriveById(@PathVariable @RequestParam Long id) {
        return ResponseEntity.ok(hardDriveService.getById(id).get());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<HttpStatus> createHardDrive(@RequestBody HardDrive hardDrive) {
        hardDriveService.create(hardDrive);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteHardDrive(@PathVariable @RequestParam Long id) {
        hardDriveService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updateHardDriveById(@PathVariable @RequestParam Long id, @RequestBody HardDriveDto hardDriveDto) {
        hardDriveService.update(id, hardDriveDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
