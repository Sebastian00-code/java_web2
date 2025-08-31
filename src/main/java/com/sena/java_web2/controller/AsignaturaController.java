package com.sena.java_web2.controller;

import com.sena.java_web2.model.Asignatura;
import com.sena.java_web2.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public Page<Asignatura> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return asignaturaService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Asignatura getById(@RequestParam long id) {
        return asignaturaService.findById(id).
                orElseThrow(() -> new RuntimeException("Asignatura no encontrada con ese id: " + id));
    }

    @PostMapping
    public Asignatura create(@RequestBody Asignatura asignatura) {
        return asignaturaService.create(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura update(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        return asignaturaService.update(id, asignatura);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        asignaturaService.deleteById(id);
    }
}
