package com.project.DBManage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.DBManage.repositories.ITallaRepository;
import com.project.DBManage.models.TallaModel;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TallaService {

    @Autowired
    ITallaRepository tallaRepository;

    // GET: todas las tallas
    public ArrayList<TallaModel> getTallas() {
        return (ArrayList<TallaModel>) tallaRepository.findAll();
    }

    // GET: talla por id
    public Optional<TallaModel> getTallaById(Long id) {
        return tallaRepository.findById(id);
    }

    // POST: crear talla
    public TallaModel createTalla(TallaModel talla) {
        return tallaRepository.save(talla);
    }

    // PUT: actualizar talla
    public TallaModel updateById(TallaModel request, Long id) {
        TallaModel talla = tallaRepository.findById(id).get();
        talla.setNombre(request.getNombre());
        return tallaRepository.save(talla);
    }

    // DELETE: eliminar talla
    public String deleteTalla(Long id) {
        try {
            tallaRepository.deleteById(id);
            return "Talla eliminada";
        } catch (Exception e) {
            return "Talla no eliminada";
        }
    }
}
