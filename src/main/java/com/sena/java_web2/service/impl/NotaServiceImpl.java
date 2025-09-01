package com.sena.java_web2.service.impl;

import com.sena.java_web2.model.Nota;
import com.sena.java_web2.repository.NotaRepository;
import com.sena.java_web2.service.NotaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;

    public NotaServiceImpl(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @Override
    public Page<Nota> findAll(Pageable pageable) {
        return notaRepository.findAll(pageable);
    }

    @Override
    public Optional<Nota> findById(Long id) {
        return notaRepository.findById(id);
    }

    @Override
    public Nota create(Nota nota) {
        return notaRepository.save(nota);
    }

    @Override
    public Nota update(Long id, Nota nota) {
        nota.setId(id); // asegúrate de que Nota tenga un método setId(Long id)
        return notaRepository.save(nota);
    }

    @Override
    public void deleteById(Long id) {
        notaRepository.deleteById(id);
    }
}

