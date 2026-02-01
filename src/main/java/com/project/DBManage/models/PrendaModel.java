package com.project.DBManage.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "prendas")
public class PrendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prenda")
    private Long idPrenda;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // Relación con Categoría
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private CategoryModel categoria;

    // Getters y Setters
    public Long getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(Long idPrenda) {
        this.idPrenda = idPrenda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public CategoryModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryModel categoria) {
        this.categoria = categoria;
    }
}
