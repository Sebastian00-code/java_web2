package com.sena.java_web2.controller;

import com.sena.java_web2.model.Profesor;
import com.sena.java_web2.service.ProfesorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public Page<Profesor> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return profesorService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Profesor getById(@PathVariable Integer id) {
        return profesorService.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));
    }

    @PostMapping
    public Profesor create(@RequestBody Profesor profesor) {
        return profesorService.create(profesor);
    }

    @PutMapping("/{id}")
    public Profesor update(@PathVariable Integer id, @RequestBody Profesor profesor) {
        return profesorService.update(id, profesor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        profesorService.deleteById(id);
    }
}

