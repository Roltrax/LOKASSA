package com.project.DBManage.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tallas")
public class TallaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talla")
    private Long idTalla;

    @Column(nullable = false)
    private String nombre;

    // Getters y Setters
    public Long getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Long idTalla) {
        this.idTalla = idTalla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
