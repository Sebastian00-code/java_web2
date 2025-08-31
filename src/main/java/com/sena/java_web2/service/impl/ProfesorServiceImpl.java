package com.sena.java_web2.service.impl;

import com.sena.java_web2.model.Profesor;
import com.sena.java_web2.repository.ProfesorRepository;
import com.sena.java_web2.service.ProfesorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorServiceImpl(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public Page<Profesor> findAll(Pageable pageable) {
        return profesorRepository.findAll(pageable);
    }

    @Override
    public Optional<Profesor> findById(Integer id) {
        return profesorRepository.findById(id);
    }

    @Override
    public Profesor create(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Integer id, Profesor profesor) {
        profesor.setId(id);
        return profesorRepository.save(profesor);
    }

    @Override
    public void deleteById(Integer id) {
        profesorRepository.deleteById(id);
    }
}
