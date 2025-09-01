package com.sena.java_web2.controller;

import com.sena.java_web2.model.Nota;
import com.sena.java_web2.service.NotaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public Page<Nota> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return notaService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Nota getById(@PathVariable Long id) {
        return notaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada con id: " + id));
    }

    @PostMapping
    public Nota create(@RequestBody Nota nota) {
        return notaService.create(nota);
    }

    @PutMapping("/{id}")
    public Nota update(@PathVariable Long id, @RequestBody Nota nota) {
        return notaService.update(id, nota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        notaService.deleteById(id);
    }
}
