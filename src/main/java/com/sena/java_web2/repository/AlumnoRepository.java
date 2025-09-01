package com.sena.java_web2.repository;

import com.sena.java_web2.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
