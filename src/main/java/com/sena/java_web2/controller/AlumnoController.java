package com.sena.java_web2.controller;

import com.sena.java_web2.model.Alumno;
import com.sena.java_web2.service.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public Page<Alumno> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return alumnoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Alumno getById(@PathVariable Long id) {
        return alumnoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoService.create(alumno);
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable Long id, @RequestBody Alumno alumno) {
        return alumnoService.update(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoService.deleteById(id);
    }
}

