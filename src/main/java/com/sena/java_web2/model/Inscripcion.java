package com.sena.java_web2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inscripciones")
@Data
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_inscripcion;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    private int anio_escolar;
}

