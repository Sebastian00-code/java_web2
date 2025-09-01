package com.sena.java_web2.controller;

import com.sena.java_web2.model.Inscripcion;
import com.sena.java_web2.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public Page<Inscripcion> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return inscripcionService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Inscripcion getById(@PathVariable long id) {
        return inscripcionService.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada con ese id: " + id));
    }

    @PostMapping
    public Inscripcion create(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.create(inscripcion);
    }

    @PutMapping("/{id}")
    public Inscripcion update(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        return inscripcionService.update(id, inscripcion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inscripcionService.deleteById(id);
    }
}

