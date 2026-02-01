package com.project.DBManage.models;

import jakarta.persistence.*;

@Entity
@Table(name = "prenda_variantes")
public class PrendaVarianteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variante")
    private Long idVariante;

    // Relación con Prenda
    @ManyToOne
    @JoinColumn(name = "id_prenda", referencedColumnName = "id_prenda")
    private PrendaModel prenda;

    // Relación con Talla
    @ManyToOne
    @JoinColumn(name = "id_talla", referencedColumnName = "id_talla")
    private TallaModel talla;

    @Column(nullable = false)
    private Integer stock;

    // Getters y Setters
    public Long getIdVariante() {
        return idVariante;
    }

    public void setIdVariante(Long idVariante) {
        this.idVariante = idVariante;
    }

    public PrendaModel getPrenda() {
        return prenda;
    }

    public void setPrenda(PrendaModel prenda) {
        this.prenda = prenda;
    }

    public TallaModel getTalla() {
        return talla;
    }

    public void setTalla(TallaModel talla) {
        this.talla = talla;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
