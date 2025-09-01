package com.sena.java_web2.service;

import com.sena.java_web2.model.Nota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NotaService {

    Page<Nota> findAll(Pageable pageable);
    Optional<Nota> findById(Long id);
    Nota create(Nota nota);
    Nota update(Long id, Nota nota);
    void deleteById(Long id);
}
