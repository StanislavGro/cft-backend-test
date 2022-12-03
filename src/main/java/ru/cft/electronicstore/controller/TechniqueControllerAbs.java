package ru.cft.electronicstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.electronicstore.entity.Technique;
import ru.cft.electronicstore.entity.dto.TechniqueDto;
import ru.cft.electronicstore.service.TechniqueService;

import java.util.List;

public abstract class TechniqueControllerAbs<T extends Technique, TDO extends TechniqueDto, S extends TechniqueService<T, TDO>>
        implements TechniqueController<T, TDO>{

    private final S techniqueService;

    protected TechniqueControllerAbs(S techniqueService) {
        this.techniqueService = techniqueService;
    }

    public ResponseEntity<List<T>> getAllTechniques(){
        return ResponseEntity.ok(techniqueService.getAll());
    }

    public ResponseEntity<T> getTechniqueById(@PathVariable @RequestParam Long id){
        return ResponseEntity.ok(techniqueService.getById(id).get());
    }

    public ResponseEntity<HttpStatus> createTechnique(@RequestBody T technique){
        techniqueService.create(technique);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteTechnique(@PathVariable @RequestParam Long id){
        techniqueService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> updateTechniqueById(@PathVariable @RequestParam Long id, @RequestBody TDO techniqueDto){
        techniqueService.update(id, techniqueDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
