package com.sena.java_web2.service;

import com.sena.java_web2.model.Asignatura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AsignaturaService {
    Page<Asignatura> findAll(Pageable pageable);
    Optional<Asignatura> findById(Long id);
    Asignatura create(Asignatura asignatura);
    Asignatura update(Long id, Asignatura asignatura);
    void deleteById(Long id);
}
