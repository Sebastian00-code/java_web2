package com.sena.java_web2.service.impl;

import com.sena.java_web2.model.Inscripcion;
import com.sena.java_web2.repository.InscripcionRepository;
import com.sena.java_web2.service.InscripcionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionRepository inscripcionRepository;

    public InscripcionServiceImpl(InscripcionRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public Page<Inscripcion> findAll(Pageable pageable) {
        return inscripcionRepository.findAll(pageable);
    }

    @Override
    public Optional<Inscripcion> findById(Long id) {
        return inscripcionRepository.findById(id);
    }

    @Override
    public Inscripcion create(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public Inscripcion update(Long id, Inscripcion inscripcion) {
        inscripcion.setId_inscripcion(id);
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public void deleteById(Long id) {
        inscripcionRepository.deleteById(id);
    }
}

