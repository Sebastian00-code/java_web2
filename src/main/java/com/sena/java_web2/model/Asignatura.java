package com.sena.java_web2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "asignaturas")
@Data
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_asignatura;

    private String nombre_asignatura;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
}
