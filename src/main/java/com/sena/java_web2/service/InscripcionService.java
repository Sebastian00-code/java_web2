package com.sena.java_web2.service;

import com.sena.java_web2.model.Inscripcion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InscripcionService {

        Page<Inscripcion> findAll(Pageable pageable);
        Optional<Inscripcion> findById(Long id);
        Inscripcion create(Inscripcion inscripcion);
        Inscripcion update(Long id, Inscripcion inscripcion);
        void deleteById(Long id);

}
