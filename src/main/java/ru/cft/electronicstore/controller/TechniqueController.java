package ru.cft.electronicstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.electronicstore.entity.Technique;
import ru.cft.electronicstore.entity.dto.TechniqueDto;

import java.util.List;

public interface TechniqueController<T extends Technique, TDO extends TechniqueDto> {

    @GetMapping(value = "/getAll")
    @ResponseBody
    @Operation(summary = "Getting all units")
    ResponseEntity<List<T>> getAllTechniques();

    @GetMapping(value = "/{id}")
    @ResponseBody
    @Operation(summary = "Getting unit by id")
    ResponseEntity<T> getTechniqueById(@PathVariable @RequestParam Long id);

    @PostMapping
    @ResponseBody
    @Operation(summary = "Creating unit")
    ResponseEntity<HttpStatus> createTechnique(@RequestBody T computer);

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @Operation(summary = "Deleting unit by id")
    ResponseEntity<HttpStatus> deleteTechnique(@PathVariable @RequestParam Long id);

    @PatchMapping(value = "/{id}")
    @ResponseBody
    @Operation(summary = "Updating unit by id")
    ResponseEntity<HttpStatus> updateTechniqueById(@PathVariable @RequestParam Long id, @RequestBody TDO techniqueDto);
}
