package com.project.DBManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.DBManage.repositories.IPrendaRepository;
import com.project.DBManage.models.PrendaModel;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PrendaService {

    @Autowired
    IPrendaRepository prendaRepository;

    // GET: todas las prendas
    public ArrayList<PrendaModel> getPrendas() {
        return (ArrayList<PrendaModel>) prendaRepository.findAll();
    }

    // GET: prenda por id
    public Optional<PrendaModel> getPrendaById(Long id) {
        return prendaRepository.findById(id);
    }

    // POST: crear prenda
    public PrendaModel createPrenda(PrendaModel prenda) {
        return prendaRepository.save(prenda);
    }

    // PUT: actualizar prenda
    public PrendaModel updateById(PrendaModel request, Long id) {
        PrendaModel prenda = prendaRepository.findById(id).get();
        prenda.setNombre(request.getNombre());
        prenda.setDescripcion(request.getDescripcion());
        prenda.setPrecio(request.getPrecio());
        prenda.setFechaCreacion(request.getFechaCreacion());
        prenda.setCategoria(request.getCategoria());
        return prendaRepository.save(prenda);
    }

    // DELETE: eliminar prenda
    public String deletePrenda(Long id) {
        try {
            prendaRepository.deleteById(id);
            return "Prenda eliminada";
        } catch (Exception e) {
            return "Prenda no eliminada";
        }
    }
}
