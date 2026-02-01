package com.project.DBManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.DBManage.repositories.IPrendaVarianteRepository;
import com.project.DBManage.models.PrendaVarianteModel;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PrendaVarianteService {

    @Autowired
    IPrendaVarianteRepository prendaVarianteRepository;

    // GET: todas las variantes
    public ArrayList<PrendaVarianteModel> getVariantes() {
        return (ArrayList<PrendaVarianteModel>) prendaVarianteRepository.findAll();
    }

    // GET: variante por id
    public Optional<PrendaVarianteModel> getVarianteById(Long id) {
        return prendaVarianteRepository.findById(id);
    }

    // POST: crear variante
    public PrendaVarianteModel createVariante(PrendaVarianteModel variante) {
        return prendaVarianteRepository.save(variante);
    }

    // PUT: actualizar variante
    public PrendaVarianteModel updateById(PrendaVarianteModel request, Long id) {
        PrendaVarianteModel variante = prendaVarianteRepository.findById(id).get();
        variante.setPrenda(request.getPrenda());
        variante.setTalla(request.getTalla());
        variante.setStock(request.getStock());
        return prendaVarianteRepository.save(variante);
    }

    // DELETE: eliminar variante
    public String deleteVariante(Long id) {
        try {
            prendaVarianteRepository.deleteById(id);
            return "Variante eliminada";
        } catch (Exception e) {
            return "Variante no eliminada";
        }
    }
}
