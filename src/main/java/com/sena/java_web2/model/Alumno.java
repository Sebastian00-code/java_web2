package com.sena.java_web2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "alumnos")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id_alumno;

    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String email;

    public void setId(Long id) {
        this.id_alumno = id;
    }

}
