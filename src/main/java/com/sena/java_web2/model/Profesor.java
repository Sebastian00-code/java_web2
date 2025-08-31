package com.sena.java_web2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "profesores")
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id_profesor;

    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;

    public void setId(Integer id) {
        this.id_profesor = id;
    }
}
