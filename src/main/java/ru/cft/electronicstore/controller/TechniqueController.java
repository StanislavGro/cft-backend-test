package ru.cft.electronicstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.Technique;
import ru.cft.electronicstore.entity.dto.ComputerDto;
import ru.cft.electronicstore.entity.dto.TechniqueDto;

import java.util.List;

public interface TechniqueController<T extends Technique, TDO extends TechniqueDto>{

    @GetMapping(value = "/getAll")
    @ResponseBody
    ResponseEntity<List<T>> getAllTechniques();

    @GetMapping(value = "/{id}")
    @ResponseBody
    ResponseEntity<T> getTechniqueById(@PathVariable @RequestParam Long id);

    @PostMapping
    @ResponseBody
    ResponseEntity<HttpStatus> createTechnique(@RequestBody T computer);

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    ResponseEntity<HttpStatus> deleteTechnique(@PathVariable @RequestParam Long id);

    @PatchMapping(value = "/{id}")
    @ResponseBody
    ResponseEntity<HttpStatus> updateTechniqueById(@PathVariable @RequestParam Long id, @RequestBody TDO techniqueDto);
}
